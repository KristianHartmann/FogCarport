package dat.startcode.model.persistence;

import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.Orderitem;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.SQLException;

public interface IOrderItemMapper {
    void createOrderItem(PartsList list, Order order) throws DatabaseException, SQLException;
}
