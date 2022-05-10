package dat.startcode.model.entities;

public class Parts {
    private int parts_id;
    private String name;
    private String description;
    private int lenght;
    private String unit;
    private int price;

    public Parts(String name, String description, int lenght, String unit, int price) {
        this.name = name;
        this.description = description;
        this.lenght = lenght;
        this.unit = unit;
        this.price = price;
    }

    public int getParts_id() {
        return parts_id;
    }

    public void setParts_id(int parts_id) {
        this.parts_id = parts_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
