package dat.startcode.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class PartsList {

    private int partslist_id;

    ArrayList<PartsListItem> partsListItemArrayList;

    public PartsList() {
        this.partsListItemArrayList = new ArrayList<>();
    }

    public void addToPartsListItemArrayList(PartsListItem partsListItem) {
        this.partsListItemArrayList.add(partsListItem);
    }
}
