package dat.startcode.model.services;

import dat.startcode.model.entities.*;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.util.ArrayList;

public class OrderFacade {

    @SneakyThrows
    public static ArrayList<Order> getAllOrder(ConnectionPool connectionPool) {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        return orderMapper.getAllOrders();
    }
    @SneakyThrows
    public static ArrayList<Order> getAllOrderByUserID(ConnectionPool connectionPool, User user) {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        return orderMapper.getAllOrdersFromUser(user);
    }

    @SneakyThrows
    public static void createFullOrder(ConnectionPool connectionPool, User user, CarportRequest carportRequest, PartsList partsList) {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        orderMapper.createFullOrder(user, carportRequest, partsList);

    }

    @SneakyThrows
    public static void createOrder(ConnectionPool connectionPool, User user) {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        orderMapper.createOrder(user);
    }

    @SneakyThrows
    public static int getNewestOrderID(ConnectionPool connectionPool){
       OrderMapper orderMapper = new OrderMapper(connectionPool);
        int orderID =  orderMapper.getNewestOrderID();
        return orderID;
    }


}

