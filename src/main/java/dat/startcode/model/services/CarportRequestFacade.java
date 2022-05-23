package dat.startcode.model.services;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportRequestMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;

import java.sql.SQLException;
import java.util.ArrayList;

public class CarportRequestFacade {

    public static ArrayList<CarportRequest> getAllCarportRequests(ConnectionPool connectionPool) throws SQLException {
        CarportRequestMapper carportRequestMapper = new CarportRequestMapper(connectionPool);
        return carportRequestMapper.getAllCarportRequest();
    }

    public static CarportRequest getCarportRequestByID(ConnectionPool connectionPool, int ID) throws SQLException {
        CarportRequestMapper carportRequestMapper = new CarportRequestMapper(connectionPool);
        return carportRequestMapper.getCarportRequestById(ID);
    }
}
