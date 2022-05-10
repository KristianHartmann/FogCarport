package dat.startcode.model.persistence;

import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper implements IUserMapper {
    ConnectionPool connectionPool;

    public UserMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }



    @Override
    public User login(String email, String password) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.SelectUserFromEmailAndPassword)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");
                    user = new User(user_id, role, balance, password, email);
                } else {
                    throw new DatabaseException("Wrong email or password");
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
                        try (PreparedStatement ps2 = connection.prepareStatement(SQLStatements.insertUser)){
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
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

    public User getUserInfoById (int user_id) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        User user = null;
        String sql = "select * from carport.user where user_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("user_id");
                    String email = rs.getString("user_email");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");
                    String password = rs.getString("password");
                    user = new User(id, role,  balance,  password,  email);
                }
                return user;
            }

        }
    }


}
