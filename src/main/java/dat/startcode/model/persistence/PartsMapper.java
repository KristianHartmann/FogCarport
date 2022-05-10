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

public class PartsMapper implements IPartsMapper{
    ConnectionPool connectionPool;

    public PartsMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public ArrayList<Parts> getParts() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Parts part = null;
        ArrayList<Parts> partsArrayList = new ArrayList<>();

        String sql = "SELECT * FROM parts";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int parts_id = rs.getInt("parts_id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int lenght = rs.getInt("lenght");
                    String unit = rs.getString("unit");
                    int balance = rs.getInt("balance");
                    int price = rs.getInt("price");
                    part = new Parts(parts_id, name, description, lenght, unit, price);
                    partsArrayList.add(part);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return partsArrayList;
    }
}
