package dat.startcode.model.entities;

public class Orderitem {

    private int orderitem_id;

    private int order_id;

    private int partslist_id;
    private int price;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getPartslist_id() {
        return partslist_id;
    }

    public void setPartslist_id(int partslist_id) {
        this.partslist_id = partslist_id;
    }

    public Orderitem(int orderitem_id, int order_id, int partslist_id, int price) {
        this.orderitem_id = orderitem_id;
        this.order_id = order_id;
        this.partslist_id = partslist_id;
        this.price = price;
    }

    public int getOrderitem_id() {
        return orderitem_id;
    }

    public void setOrderitem_id(int orderitem_id) {
        this.orderitem_id = orderitem_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
