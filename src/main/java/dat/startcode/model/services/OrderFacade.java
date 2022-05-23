package dat.startcode.model.services;

import dat.startcode.model.entities.Order;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;
import lombok.SneakyThrows;
import java.util.ArrayList;

public class OrderFacade {

    @SneakyThrows
    public static ArrayList<Order> getAllOrder(ConnectionPool connectionPool) {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        return orderMapper.getAllOrders();
    }

    @SneakyThrows
    public static void createFullOrder(ConnectionPool connectionPool){
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        orderMapper.createFullOrder();
    }


}
