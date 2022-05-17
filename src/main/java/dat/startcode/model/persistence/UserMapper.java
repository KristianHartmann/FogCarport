package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper extends SuperMapper implements IUserMapper {


    public UserMapper(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public User login(String email, String password) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectUserFromEmailAndPassword)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    throw new DatabaseException("Wrong email or password");
                } else {
                    int user_id = rs.getInt("user_id");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");
                    user = new User(user_id, role, balance, password, email);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    @Override
    public User createUser(String email, String password, String role) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String getEmailFromPerson = "select email from person where email = '" + email + "'";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(getEmailFromPerson)) {
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    try (PreparedStatement ps2 = connection.prepareStatement(SQLStatements.insertUser)) {
                        ResultSet rs = ps.executeQuery();
                        if (!rs.next()) {
                            return null;
                        } else {
                            ps2.setString(1, rs.getString("email"));
                            ps2.setString(2, password);
                            ps2.setString(3, role);
                        }
                        int rowsAffected2 = ps2.executeUpdate();
                        if (rowsAffected2 == 1) {
                            user = new User(email, password, role);
                        } else {
                            throw new DatabaseException("The user with email = " + email + " could not be inserted into the database");
                        }
                    }
                } else {
                    throw new DatabaseException("Could not find a person with this email.");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Failed");
        }
        return user;

    }

    public User getUserInfoById(int user_id) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        User user = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectAllUserFromUserID)) {
                ps.setInt(1, user_id);
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    return null;
                }
                int id = rs.getInt("user_id");
                String email = rs.getString("email");
                String role = rs.getString("role");
                int balance = rs.getInt("balance");
                String password = rs.getString("password");
                user = new User(id, role, balance, password, email);
                return user;
            }
        }
    }

    public void changePassword(String password, int userId) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.updateUserPasswordById)) {
                ps.setString(1, password);
                ps.setInt(2, userId);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected != 1) {
                    throw new SQLException("Failed");
                }
            }
        }
    }

    @Override
    public void addUserBalance(int balance, User user) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.addUserBalanace)) {
                ps.setInt(1, balance);
                ps.setInt(2, user.getUser_id());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected != 1) {
                    throw new SQLException("Failed");
                }
            }
        }
    }

    @Override
    public void removeUserBalance(int balance, User user) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.removeUserBalance)) {
                ps.setInt(1, balance);
                ps.setInt(2, user.getUser_id());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected != 1) {
                    throw new SQLException("Failed");
                }
            }
        }
    }

    @Override
    public int getUserIDFromEmail(User user) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectUserIDFromEmail)) {
                ps.setString(1, user.getEmail());
                ResultSet rs =  ps.executeQuery();
                if(rs.next()){
                    return rs.getInt("user_id");
                }
            }
        }
        return Integer.parseInt(null);
    }



}
