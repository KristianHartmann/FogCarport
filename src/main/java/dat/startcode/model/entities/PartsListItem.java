package dat.startcode.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter // Laver getter og setter for hele klassen, så det ikke skal skrives ved hver metode.
public class PartsListItem {

    Part part;
    int amount;
    String useDesc;

    public PartsListItem(Part part, int amount, String useDesc) {
        this.part = part;
        this.amount = amount;
        this.useDesc = useDesc;
    }



}
