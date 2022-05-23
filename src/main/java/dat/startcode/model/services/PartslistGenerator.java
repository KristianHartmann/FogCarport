package dat.startcode.model.services;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.Parts;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.PartsMapper;

import java.util.ArrayList;

public class PartslistGenerator {
    ConnectionPool connectionPool;

    public PartslistGenerator(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    public PartsList generateFlatroofPartsList(CarportRequest request) throws DatabaseException {
        PartsMapper partsMapper = new PartsMapper(connectionPool);
        ArrayList<Parts> partsArrayList = partsMapper.getParts();
        FlatRoofCalc calc = new FlatRoofCalc(request.getWidth(), request.getLength(), request.getToolbox_width(), request.getToolbox_length());
        PartsList partsList = new PartsList();
        for (Parts parts : partsArrayList) {
            if(parts.getParts_id() != 0){
                PartsListItem partsListItem = new PartsListItem(parts, calc.getAmount(parts.getParts_id()), parts.getDescription());
                partsList.addToPartsListItemArrayList(partsListItem);
            }
        }
        return partsList;
    }

    public PartsList generateRaisedroofPartsList(CarportRequest request) throws DatabaseException {
        PartsMapper partsMapper = new PartsMapper(connectionPool);
        ArrayList<Parts> partsArrayList = partsMapper.getParts();
        RaisedRoofCalc calc = new RaisedRoofCalc(request.getWidth(), request.getLength(), request.getToolbox_width(), request.getToolbox_length(), request.getRoofpitch());
        PartsList partsList = new PartsList();
        for (Parts parts : partsArrayList) {
            if(parts.getParts_id() != 0){
                PartsListItem partsListItem = new PartsListItem(parts, calc.getAmount(parts.getParts_id()), parts.getDescription());
                partsList.addToPartsListItemArrayList(partsListItem);
            }
        }
        return partsList;
    }



    // FOR TESTING
    public static void main(String[] args) throws DatabaseException {
        CarportRequest request = new CarportRequest(780, 600, "flat", 25, 210, 530, null);
        ConnectionPool connectionPool = new ConnectionPool();

        PartslistGenerator generator = new PartslistGenerator(connectionPool);
        PartsList test = generator.generateFlatroofPartsList(request);
        PartsList test2 = generator.generateRaisedroofPartsList(request);
        ArrayList<PartsListItem> itemList = test.getPartsListItemArrayList();
        ArrayList<PartsListItem> itemList2 = test2.getPartsListItemArrayList();

        for (PartsListItem item : itemList) {
            System.out.println("Description: "+ item.getDescription() + " amount: " + item.getAmount() + " part name: " + item.getParts().getName());
        }
//        for (PartsListItem item : itemList2) {
//            System.out.println("Description: "+ item.getDescription() + " amount: " + item.getAmount() + " part name: " + item.getParts().getName());
//        }
    }
}
