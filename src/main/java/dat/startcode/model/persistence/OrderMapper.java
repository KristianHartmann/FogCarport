package dat.startcode.model.persistence;

import dat.startcode.model.entities.*;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class OrderMapper extends SuperMapper implements IOrderMapper {
    UserMapper userMapper = new UserMapper(connectionPool);

    public OrderMapper(ConnectionPool connectionPool) {
        super(connectionPool);
    }



    @Override
    public void createOrder(User user) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement( SQLStatements.insertOrder)) {
                ps.setInt(1, user.getUser_id());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("success!");
                } else {
                    throw new DatabaseException("couldn't create order for " + user.getEmail());
                }
            }
        }
    }


    @Override
    public void createFullOrder(User user, CarportRequest request, PartsList list, Orderitem orderitem) throws SQLException, DatabaseException {
        CarportRequestMapper carportRequestMapper = new CarportRequestMapper(connectionPool);
        PartsListMapper partsListMapper = new PartsListMapper(connectionPool);
        PartsListItemMapper partsListItemMapper = new PartsListItemMapper(connectionPool);
        OrderItemMapper orderItemMapper = new OrderItemMapper(connectionPool);

        createOrder(user);
        carportRequestMapper.createCarportrequest(request);
        partsListMapper.createPartsList(request);
        for (PartsListItem item : list.getPartsListItemArrayList()) {
            partsListItemMapper.createPartsListItem(item, list.getPartslist_id());
        }
        Order order = new Order(getNewestOrderID(), user);
        orderitem.setOrder(order);
        orderItemMapper.createOrderItem(list.getPartslist_id(), orderitem);
    }


    @Override
    public void deleteOrder(int id) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.deleteOrderItem)) {
                try (PreparedStatement ps2 = connection.prepareStatement(SQLStatements.deleteOrder)) {
                    ps.setInt(1, id);
                    ps2.setInt(1, id);
                    int rowsAffected = ps.executeUpdate();
                    int rowsAffected2 = ps2.executeUpdate();
                    if (rowsAffected == 1 && rowsAffected2 == 1) {
                        System.out.println("success!");
                    } else {
                        throw new DatabaseException("could not delete order with ID " + id);
                    }
                }
            }
        }
    }

    @Override
    public ArrayList<Order> getAllOrdersFromUser(User user) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<Order> orderArrayList = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectAllOrderFromUserId)) {
                ps.setInt(1, user.getUser_id());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    orderArrayList.add(new Order(order_id, userMapper.getUserInfoById(user_id)));
                }
                return orderArrayList;
            }

        }
    }

    @Override
    public ArrayList<Order> getAllOrders() throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<Order> orderArrayList = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectAllOrder)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    orderArrayList.add(new Order(order_id, userMapper.getUserInfoById(user_id)));
                }
                return orderArrayList;
            }

        }

    }

    @Override
    public int getNewestOrderID() throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectMaxOrder)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int order_id = rs.getInt(1);
                    return order_id;
                }
            }
        } return Integer.parseInt(null);
    }
}
