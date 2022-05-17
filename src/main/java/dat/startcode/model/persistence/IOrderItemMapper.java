package dat.startcode.model.persistence;

import dat.startcode.model.entities.Orderitem;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.SQLException;

public interface IOrderItemMapper {
    void createOrderItem(int partslistid, Orderitem orderitem) throws DatabaseException, SQLException;
}
