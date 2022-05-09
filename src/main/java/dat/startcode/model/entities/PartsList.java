package dat.startcode.model.entities;

import java.util.ArrayList;

public class PartsList {
    ArrayList<PartsListItem> partsListItemArrayList;

    public PartsList() {
        this.partsListItemArrayList = new ArrayList<>();
    }

    public void setPartsListItemArrayList(PartsListItem partsListItem) {
        this.partsListItemArrayList.add(partsListItem);
    }
}
