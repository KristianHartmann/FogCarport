package dat.startcode.model.persistence;

import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper implements IOrderMapper{
    ConnectionPool connectionPool;
    UserMapper userMapper = new UserMapper(connectionPool);

    public OrderMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void createOrder(User user) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO carport.order (user_id) VALUES (?);";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
    public void deleteOrder(int id) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE FROM orderitem WHERE order_id = ?;";
        String sql2 = "DELETE FROM `order` WHERE order_id = ?;";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                try (PreparedStatement ps2 = connection.prepareStatement(sql2)) {
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
        String sql = "select * from carport.order where user_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
        String sql = "select * from carport.order";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
        String sql = "SELECT MAX(order_id) FROM carport.order;";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int order_id = rs.getInt(1);
                    return order_id;
                }
            }
        } return Integer.parseInt(null);
    }
}
