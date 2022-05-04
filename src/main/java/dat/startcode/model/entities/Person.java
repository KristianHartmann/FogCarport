package dat.startcode.model.entities;

public class Person {
    private String email;
    private String address;
    private String name;
    private String phonenumber;
    private int zipcode;

    public Person(String email, String address, String name, String phonenumber, int zipcode) {
        this.email = email;
        this.address = address;
        this.name = name;
        this.phonenumber = phonenumber;
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
