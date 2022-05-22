package dat.startcode.model.persistence;

import dat.startcode.model.entities.Person;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPersonMapper {

    ArrayList<Person> getAllPersons() throws SQLException;
}
