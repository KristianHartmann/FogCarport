package dat.startcode.model.persistence;

import dat.startcode.model.entities.Parts;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartsMapper extends SuperMapper implements IPartsMapper{


    public PartsMapper(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public ArrayList<Parts> getParts() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Parts part = null;
        ArrayList<Parts> partsArrayList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectAllParts)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int parts_id = rs.getInt("parts_id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int length = rs.getInt("length");
                    String unit = rs.getString("unit");
                    int price = rs.getInt("price");
                    part = new Parts(parts_id, name, description, length, unit, price);
                    partsArrayList.add(part);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, ex.getMessage());
        }
        return partsArrayList;
    }
}
