package dat.startcode.model.persistence;

import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.Orderitem;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.PartsListFacade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderItemMapper extends SuperMapper implements IOrderItemMapper {
    public OrderItemMapper(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public void createOrderItem(PartsList list, Order order) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.insertOrderItem)) {
                ps.setInt(1, list.getPartslist_id());
                ps.setInt(2, PartsListFacade.getPartsListSum(list) + 500); //500 is buffer
                ps.setInt(3, order.getOrder_id());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("success!");
                } else {
                    throw new DatabaseException("couldn't create partslistitem");
                }
            }
        }
    }

    public Orderitem getOrderItemByOrderId(Order order) throws DatabaseException, SQLException {
        Orderitem orderitem = null;
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectAllOrderItemByOrderID)) {
                ps.setInt(1, order.getOrder_id());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int orderitem_id = rs.getInt(1);
                    int partslist_id = rs.getInt(2);
                    int price = rs.getInt(3);
                    int order_id = rs.getInt(4);
                    orderitem = new Orderitem(orderitem_id, order_id,partslist_id, price);
                    return orderitem;
                }
            }
        }
        return null;
    }


}
