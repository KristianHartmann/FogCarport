package dat.startcode.model.services;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.entities.User;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.PartsListMapper;
import dat.startcode.model.persistence.UserMapper;
import lombok.SneakyThrows;

import java.util.ArrayList;

public class PartsListFacade {

    @SneakyThrows
    public static  PartsList getPartsList(ConnectionPool connectionPool, CarportRequest request) {
        PartslistGenerator generator = new PartslistGenerator(connectionPool);
        PartsList list = generator.generateFlatroofPartsList(request);
        PartsListMapper mapper = new PartsListMapper(connectionPool);
        if(mapper.getPartsListIDByRequestID(request) != 0){
            list.setPartslist_id(mapper.getPartsListIDByRequestID(request));
        } else{
            mapper.createPartsList(request);
            list.setPartslist_id(mapper.getPartsListIDByRequestID(request));
        }
        return list;
    }


    @SneakyThrows
    public static int getPartsListSum(PartsList list) {
        int totalPrice = 0;
        for (PartsListItem listItem : list.getPartsListItemArrayList() ) {
            totalPrice = totalPrice + (listItem.getParts().getPrice() * listItem.getAmount());
        }
        return totalPrice;
    }    @SneakyThrows
    public static void createPartsList(ConnectionPool connectionPool, CarportRequest request) {
        PartsListMapper mapper = new PartsListMapper(connectionPool);
        mapper.createPartsList(request);
    }
    @SneakyThrows
    public static int getNewestPartsList(ConnectionPool connectionPool) {
        PartsListMapper mapper = new PartsListMapper(connectionPool);
        return mapper.getNewestPartsList();
    }


}
