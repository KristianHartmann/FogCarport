package dat.startcode.model.services;

import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.Orderitem;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderItemMapper;
import lombok.SneakyThrows;

public class OrderItemFacade {

    @SneakyThrows
    public static Orderitem getOrderItemByOrderId(int orderid, ConnectionPool connectionPool) {
        OrderItemMapper mapper = new OrderItemMapper(connectionPool);
        return mapper.getOrderItemByOrderId(orderid);

    }
}
