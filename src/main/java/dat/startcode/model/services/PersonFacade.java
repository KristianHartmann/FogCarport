package dat.startcode.model.services;

import dat.startcode.model.entities.Person;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.PersonMapper;

import java.sql.SQLException;
import java.util.ArrayList;

public class PersonFacade {

    public static ArrayList<Person> getAllPersons(ConnectionPool connectionPool) throws SQLException {
        PersonMapper personMapper = new PersonMapper(connectionPool);
        return personMapper.getAllPersons();
    }




}
