package dat.startcode.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter // Laver getter og setter for hele klassen, så det ikke skal skrives ved hver metode.
public class PartsListItem {



    private int partslistitem_id;
    private Parts parts;
    private int amount;
    private String description;

    public PartsListItem(Parts parts, int amount, String description) {
        this.parts = parts;
        this.amount = amount;
        this.description = description;
    }



}
