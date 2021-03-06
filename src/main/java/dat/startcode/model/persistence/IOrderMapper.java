package dat.startcode.model.persistence;

import dat.startcode.model.entities.*;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IOrderMapper {
    // Mangler jeg at lave en et nyt ordre objekt i den her metode eller er det ligemeget? - LIGEMEGET

    void createOrder(User user) throws DatabaseException, SQLException;



    void createFullOrder(User user, CarportRequest request, PartsList list) throws SQLException, DatabaseException;

    void deleteOrder(int id) throws DatabaseException, SQLException;

    ArrayList<Order> getAllOrdersFromUser(User user) throws DatabaseException, SQLException;

    ArrayList<Order> getAllOrders() throws DatabaseException, SQLException;

    int getNewestOrderID() throws SQLException;
}
