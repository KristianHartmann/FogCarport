package dat.startcode.model.services;

import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.entities.Person;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.PartsListItemMapper;
import dat.startcode.model.persistence.PersonMapper;
import lombok.SneakyThrows;

import java.sql.SQLException;
import java.util.ArrayList;

public class PartsListItemFacade {

    @SneakyThrows
    public static ArrayList<PartsListItem> getPartsListItems(ConnectionPool connectionPool, int PartsListID) throws SQLException {
        PartsListItemMapper partsListItemMapper = new PartsListItemMapper(connectionPool);
        return partsListItemMapper.getPartsListItems(PartsListID);
    }

}
