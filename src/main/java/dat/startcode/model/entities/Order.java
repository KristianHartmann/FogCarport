package dat.startcode.model.entities;

public class Order {
    private int order_id;
    private User user;

    public Order(User user) {
        this.user = user;
    }
    public Order(int order_id, User user) {
        this.order_id = order_id;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
