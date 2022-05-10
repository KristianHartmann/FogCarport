package dat.startcode.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Part {
    int part_ID;
    String name;
    String description;
    double length;
    String unit;
    int piecePrice;
    int categori;

    public Part(int part_ID, String name, String description, double length, String unit, int piecePrice, int categori) {
        this.part_ID = part_ID;
        this.name = name;
        this.description = description;
        this.length = length;
        this.unit = unit;
        this.piecePrice = piecePrice;
        this.categori = categori;
    }
}
