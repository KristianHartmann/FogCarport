package dat.startcode.model.services;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportRequestMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.PartsListMapper;
import dat.startcode.model.persistence.UserMapper;
import lombok.SneakyThrows;

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
    public static boolean isRequestApproved(ConnectionPool connectionPool, int ID) throws SQLException {
        CarportRequestMapper carportRequestMapper = new CarportRequestMapper(connectionPool);
        return carportRequestMapper.isRequestApproved(ID);
    }
    @SneakyThrows
    public static void deleteOrder(ConnectionPool connectionPool, int ID){
        CarportRequestMapper carportRequestMapper = new CarportRequestMapper(connectionPool);
        carportRequestMapper.deleteCarportRequest(ID);
    }
    @SneakyThrows
    public static CarportRequest getRequestByPartsListID(ConnectionPool connectionPool, int partslistID){
        CarportRequestMapper carportRequestMapper = new CarportRequestMapper(connectionPool);
       return carportRequestMapper.getCarportRequestByPartsListId(partslistID);
    }

    @SneakyThrows
    public static void createCartportRequest(ConnectionPool connectionPool, CarportRequest request) throws SQLException {
        CarportRequestMapper carportRequestMapper = new CarportRequestMapper(connectionPool);
        carportRequestMapper.createCarportrequest(request);
    }

    @SneakyThrows
    public static int getNewestCarportRequest(ConnectionPool connectionPool) {
        CarportRequestMapper carportRequestMapper = new CarportRequestMapper(connectionPool);
        return carportRequestMapper.getNewestCarportRequest();
    }


}

