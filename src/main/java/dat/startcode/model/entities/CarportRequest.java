package dat.startcode.model.entities;

public class CarportRequest {
    private int carport_request_id;
    private int lenght;
    private int width;
    private String rooftype;
    private int roofpitch;
    private int toolbox_lenght;
    private int toolbox_width;
    private User user;

    public CarportRequest(int lenght, int width, String rooftype, int roofpitch, int toolbox_lenght, int toolbox_width, User user) {
        this.lenght = lenght;
        this.width = width;
        this.rooftype = rooftype;
        this.roofpitch = roofpitch;
        this.toolbox_lenght = toolbox_lenght;
        this.toolbox_width = toolbox_width;
        this.user = user;
    }

    public int getCarport_request_id() {
        return carport_request_id;
    }

    public void setCarport_request_id(int carport_request_id) {
        this.carport_request_id = carport_request_id;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getRooftype() {
        return rooftype;
    }

    public void setRooftype(String rooftype) {
        this.rooftype = rooftype;
    }

    public int getRoofpitch() {
        return roofpitch;
    }

    public void setRoofpitch(int roofpitch) {
        this.roofpitch = roofpitch;
    }

    public int getToolbox_lenght() {
        return toolbox_lenght;
    }

    public void setToolbox_lenght(int toolbox_lenght) {
        this.toolbox_lenght = toolbox_lenght;
    }

    public int getToolbox_width() {
        return toolbox_width;
    }

    public void setToolbox_width(int toolbox_width) {
        this.toolbox_width = toolbox_width;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
