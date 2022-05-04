package dat.startcode.model.persistence;

import dat.startcode.model.entities.Person;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonMapper implements IPersonMapper{
    ConnectionPool connectionPool;

    public PersonMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Person createPerson(String email, String address, String name, String phonenumber, int zipcode) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Person person;
        String sql = "INSERT INTO `carport`.`person` (`email`, `address`, `name`, `phonenumber`, `zipcode`) VALUES  (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, address);
                ps.setString(3, name);
                ps.setString(4, phonenumber);
                ps.setInt(5, zipcode);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    person = new Person(email, address, name, phonenumber, zipcode);
                } else {
                    throw new DatabaseException("The person with email = " + email + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert person into database");
        }
        return person;
    }

}
