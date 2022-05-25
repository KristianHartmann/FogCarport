package dat.startcode.model.persistence;

import dat.startcode.model.entities.Person;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonMapper extends SuperMapper implements IPersonMapper {


    public PersonMapper(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    public void createPerson(String email, String address, String name, String phonenumber, int zipcode) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Person person;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.insertPerson)) {
                ps.setString(1, email);
                ps.setString(2, address);
                ps.setString(3, name);
                ps.setString(4, phonenumber);
                ps.setInt(5, zipcode);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected != 1) {
                    throw new DatabaseException("The person with email = " + email + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert person into database");
        }
    }

    public Person selectAllFromPersonByEmail(User user) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        Person person = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectAllFromPersonByEmail)) {
                ps.setString(1, user.getEmail());
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    return null;
                }
                String email = rs.getString("email");
                String address = rs.getString("address");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phonenumber");
                int zipCode = rs.getInt("zipcode");
                String city = rs.getString("city");
                person = new Person(email, address, name, phoneNumber, city, zipCode);
                return person;
            }
        }
    }

    @Override
    public ArrayList<Person> getAllPersons() throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<Person> personArrayList = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectAllPerson)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String email = rs.getString(1);
                    String address = rs.getString(2);
                    String name = rs.getString(3);
                    String phoneNumber = rs.getString(4);
                    int zipcode = rs.getInt(5);
                    String city = rs.getString(6);
                    personArrayList.add(new Person(email, address, name, phoneNumber, city, zipcode));
                }
            }
        }
        return personArrayList;
    }

    @Override
    public boolean isPersonAUser(String email) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.isPersonAUser)) {
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }


}
