package dat.startcode.model.entities;

public class Orderitem {

    private int orderitem_id;
    private Order order;
    private int price;

    public Orderitem(Order order, int price) {
        this.order = order;
        this.price = price;
    }

    public int getOrderitem_id() {
        return orderitem_id;
    }

    public void setOrderitem_id(int orderitem_id) {
        this.orderitem_id = orderitem_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
