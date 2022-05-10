package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarportRequestMapper extends SuperMapper {

    public CarportRequestMapper(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    public CarportRequest getCarportRequestById(int carport_request_id) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        CarportRequest carportRequest;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectCarportRequestByID)) {
                try (PreparedStatement ps2 = connection.prepareStatement(SQLStatements.selectAllUser)) {
                    ps.setInt(1, carport_request_id);
                    ResultSet rs = ps.executeQuery();
                    ResultSet rs2 = ps2.executeQuery();
                    if (rs.next()) {
                        int length = rs.getInt("length");
                        int width = rs.getInt("width");
                        String rooftype = rs.getString("rooftype");
                        int roofpitch = rs.getInt("roofpitch");
                        int toolbox_length = rs.getInt("toolbox_length");
                        int toolbox_width = rs.getInt("toolbox_width");
                        if (rs2.next()) {
                            int user_id = rs2.getInt("user_id");
                            String role = rs2.getString("role");
                            int balance = rs2.getInt("balance");
                            String password = rs2.getString("password");
                            String email = rs2.getString("email");
                            carportRequest = new CarportRequest(length, width, rooftype, roofpitch, toolbox_length, toolbox_width, new User(user_id, role, balance, password, email));
                            return carportRequest;
                        }
                    }
                }
            }
        }
        return null;
    }
}
