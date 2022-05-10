package dat.startcode.model.entities;

public class Partslist {

    private int partslist_id;
    private int parts_amount;
    private Parts parts;
    private CarportRequest carportRequest;

    public Partslist(int parts_amount, Parts parts, CarportRequest carportRequest) {
        this.parts_amount = parts_amount;
        this.parts = parts;
        this.carportRequest = carportRequest;
    }

    public int getPartslist_id() {
        return partslist_id;
    }

    public void setPartslist_id(int partslist_id) {
        this.partslist_id = partslist_id;
    }

    public int getParts_amount() {
        return parts_amount;
    }

    public void setParts_amount(int parts_amount) {
        this.parts_amount = parts_amount;
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public CarportRequest getCarportRequest() {
        return carportRequest;
    }

    public void setCarportRequest(CarportRequest carportRequest) {
        this.carportRequest = carportRequest;
    }
}
