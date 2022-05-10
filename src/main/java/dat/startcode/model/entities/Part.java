package dat.startcode.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Part {
    int parts_id;
    private double length;
    private String name;
    private String description;
    private String unit;

    private int price;



    public Part(int parts_id, String name, String description, double length, String unit, int price) {
        this.parts_id = parts_id;
        this.name = name;
        this.description = description;
        this.length = length;
        this.unit = unit;
        this.price = price;
    }
}
