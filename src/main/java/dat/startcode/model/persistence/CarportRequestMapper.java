package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                            carportRequest.setCarport_request_id(carport_request_id);
                            return carportRequest;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void createCarportrequest(CarportRequest request) throws SQLException, DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        CarportRequest carportRequest;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.insertCarportRequest)) {
                try (PreparedStatement ps2 = connection.prepareStatement(SQLStatements.selectAllUser)) {
                    ps.setInt(2, request.getLength());
                    ps.setInt(3, request.getWidth());
                    ps.setString(4, request.getRooftype());
                    ps.setInt(5, request.getRoofpitch());
                    ps.setInt(6, request.getToolbox_length());
                    ps.setInt(7, request.getToolbox_width());
                    ps.setString(8, request.getUser().getEmail());
                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected == 1) {
                        throw new SQLException("Failed");
                    } else {
                        throw new DatabaseException("Could not find a person with this email.");
                    }
                }
            }
        } catch (SQLException | DatabaseException ex) {
            throw new DatabaseException(ex, "Failed");
        }
    }

    public ArrayList<CarportRequest> getAllCarportRequest() throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<CarportRequest> carportRequestArrayList = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectAllCarportRequest)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int carport_request_id = rs.getInt(1);
                    int length = rs.getInt(2);
                    int width = rs.getInt(3);
                    String rooftype = rs.getString(4);
                    int roofPitch = rs.getInt(5);
                    int toolbox_length = rs.getInt(6);
                    int toolbox_width = rs.getInt(7);
                    String email = rs.getString(8);
                    carportRequestArrayList.add(new CarportRequest(carport_request_id, length, width, rooftype, roofPitch, toolbox_length, toolbox_width, email));
                }
            }
        }
        return carportRequestArrayList;
    }

    public void deleteCarportRequest(int ID) throws SQLException{
        Logger.getLogger("web").log(Level.INFO, "");
              try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(SQLStatements.deleteCarportRequest)){
                ps.setInt(1, ID);
                int rowsAffected = ps.executeUpdate();
                if(rowsAffected == 1){
                    System.out.println("Succes");
                }else{
                    throw new SQLException();
                }
            }
        }
    }
}
