package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer;

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
                ps.setInt(1, carport_request_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String email = rs.getString("email");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String rooftype = rs.getString("rooftype");
                    int roofpitch = rs.getInt("roofpitch");
                    int toolbox_length = rs.getInt("toolbox_length");
                    int toolbox_width = rs.getInt("toolbox_width");
                    carportRequest = new CarportRequest(length, width, rooftype, roofpitch, toolbox_length, toolbox_width, email);
                    carportRequest.setCarport_request_id(carport_request_id);
                    return carportRequest;
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
                ps.setInt(1, request.getLength());
                ps.setInt(2, request.getWidth());
                ps.setString(3, request.getRooftype());
                ps.setInt(4, request.getRoofpitch());
                ps.setInt(5, request.getToolbox_length());
                ps.setInt(6, request.getToolbox_width());
                ps.setString(7, request.getUser().getEmail());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("success");
                } else {
                    throw new DatabaseException("Could not find a person with this email.");
                }
            }
        }
    }

    public void createCarportrequestEmail(CarportRequest request, String email) throws SQLException, DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        CarportRequest carportRequest;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.insertCarportRequest)) {
                ps.setInt(1, request.getLength());
                ps.setInt(2, request.getWidth());
                ps.setString(3, request.getRooftype());
                ps.setInt(4, request.getRoofpitch());
                ps.setInt(5, request.getToolbox_length());
                ps.setInt(6, request.getToolbox_width());
                ps.setString(7, email);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("success");
                } else {
                    throw new DatabaseException("Could not find a person with this email.");
                }
            }
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

    public void deleteCarportRequest(int ID) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.deleteCarportRequest)) {
                ps.setInt(1, ID);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("Succes");
                } else {
                    throw new SQLException();
                }
            }
        }
    }

    public boolean isRequestApproved(int ID) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.isRequestApproved)) {
                ps.setInt(1, ID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public CarportRequest getCarportRequestByPartsListId(int partslistID) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        CarportRequest carportRequest;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectRequestByPartsListID)) {
                ps.setInt(1, partslistID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("carport_request_id");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String rooftype = rs.getString("rooftype");
                    int roofpitch = rs.getInt("roofpitch");
                    int toolbox_length = rs.getInt("toolbox_length");
                    int toolbox_width = rs.getInt("toolbox_width");
                    String email = rs.getString("email");
                    carportRequest = new CarportRequest(id, length, width, rooftype, roofpitch, toolbox_length, toolbox_width, email);
                    return carportRequest;
                }
            }
        }
        return null;
    }

    public int getNewestCarportRequest() throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.getNewestCarportRequest)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int partsListID = rs.getInt(1);
                    return partsListID;
                }
            }
        } return Integer.parseInt(null);
    }

}
