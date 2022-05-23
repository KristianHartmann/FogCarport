package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartsListMapper extends SuperMapper implements IPartslist {

    public PartsListMapper(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    public void createPartsList(CarportRequest request) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.insertPartsList)) {
                ps.setInt(1, request.getCarport_request_id());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("success!");
                } else {
                    throw new DatabaseException("couldn't create partslist");
                }
            }
        }
    }

    public int getPartsListIDByRequestID(CarportRequest request) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.SelectAllPartsList)) {
                ps.setInt(1, request.getCarport_request_id());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int partslistID = rs.getInt(1);
                    return  partslistID;
                }
            }
        }
        return 0;
    }
}
