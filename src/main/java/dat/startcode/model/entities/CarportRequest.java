package dat.startcode.model.entities;

public class CarportRequest {
    private int carport_request_id;
    private int length;
    private int width;
    private String rooftype;
    private int roofpitch;
    private int toolbox_length;
    private int toolbox_width;
    private User user;

    public CarportRequest(int length, int width, String rooftype, int roofpitch, int toolbox_length, int toolbox_width, User user) {
        this.length = length;
        this.width = width;
        this.rooftype = rooftype;
        this.roofpitch = roofpitch;
        this.toolbox_length = toolbox_length;
        this.toolbox_width = toolbox_width;
        this.user = user;
    }
    public int getCarport_request_id() {
        return carport_request_id;
    }

    public void setCarport_request_id(int carport_request_id) {
        this.carport_request_id = carport_request_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public int getToolbox_length() {
        return toolbox_length;
    }

    public void setToolbox_length(int toolbox_length) {
        this.toolbox_length = toolbox_length;
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
