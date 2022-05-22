package dat.startcode.model.services;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.entities.User;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;
import lombok.SneakyThrows;

import java.util.ArrayList;

public class PartsListFacade {

    @SneakyThrows
    public static  PartsList getPartsList(ConnectionPool connectionPool, CarportRequest request) {
        PartslistGenerator generator = new PartslistGenerator(connectionPool);
        return generator.generateFlatroofPartsList(request);
    }


}
