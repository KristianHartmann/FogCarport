package dat.startcode.model.persistence;

import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.Orderitem;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderItemMapper extends SuperMapper implements IOrderItemMapper{
    public OrderItemMapper(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public void createOrderItem(int partslistid, Orderitem orderitem) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.insertOrderItem)) {
                ps.setInt(1, partslistid);
                ps.setInt(2, orderitem.getPrice());
                ps.setInt(3, orderitem.getOrder().getOrder_id());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("success!");
                } else {
                    throw new DatabaseException("couldn't create partslistitem");
                }
            }
        }
    }
}
