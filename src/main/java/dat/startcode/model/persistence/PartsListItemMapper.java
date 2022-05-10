package dat.startcode.model.persistence;

import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartsListItemMapper {
    ConnectionPool connectionPool;

    public PartsListItemMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public void createPartsListItem(PartsListItem partsListItem, int partslist_id) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO partslistitem (amount, description, partslist_id, parts_id) VALUES (?, ?, ?, ?);";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, partsListItem.getAmount());
                ps.setString(2, partsListItem.getDescription());
                ps.setInt(3, partslist_id);
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
}
