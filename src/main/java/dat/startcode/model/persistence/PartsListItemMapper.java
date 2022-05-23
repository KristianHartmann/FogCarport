package dat.startcode.model.persistence;

import dat.startcode.model.entities.Parts;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartsListItemMapper extends SuperMapper {


    public PartsListItemMapper(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    public void createPartsListItem(PartsListItem partsListItem, int partslistid) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.insertPartsListItem)) {
                ps.setInt(1, partsListItem.getAmount());
                ps.setString(2, partsListItem.getDescription());
                ps.setInt(3, partslistid);
                ps.setInt(4, partsListItem.getParts().getParts_id());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("success!");
                } else {
                    throw new DatabaseException("couldn't create partslistitem");
                }
            }
        }
    }

    public ArrayList<PartsListItem> getPartsListItems(int partslist_id) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<PartsListItem> partsListItemArrayList = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectPartsListItemsFromID)) {
                ps.setInt(1, partslist_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int amount = rs.getInt("amount");
                    String itemDescription = rs.getString(2);
                    String name = rs.getString("name");
                    String partDescription = rs.getString(4);
                    int length = rs.getInt("length");
                    String unit = rs.getString("unit");
                    int price = rs.getInt("price");
                    PartsListItem partsListItem = new PartsListItem(new Parts(null, name, partDescription, length, unit, price), amount, itemDescription);
                    partsListItemArrayList.add(partsListItem);
                }
                return partsListItemArrayList;
            }
        }
    }
    public PartsList getPartsListByRequestID(int request_id) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<PartsListItem> partsListItemArrayList = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQLStatements.selectPartsListItemsFromRequestID)) {
                ps.setInt(1, request_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int amount = rs.getInt("amount");
                    String itemDescription = rs.getString(2);
                    String name = rs.getString("name");
                    String partDescription = rs.getString(4);
                    int length = rs.getInt("length");
                    String unit = rs.getString("unit");
                    int price = rs.getInt("price");
                    PartsListItem partsListItem = new PartsListItem(new Parts(null, name, partDescription, length, unit, price), amount, itemDescription);
                    partsListItemArrayList.add(partsListItem);
                }
                PartsList list = new PartsList();
                list.setPartsListItemArrayList(partsListItemArrayList);
                return list;
            }
        }
    }


}
