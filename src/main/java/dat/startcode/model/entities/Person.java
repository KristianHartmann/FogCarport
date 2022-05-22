package dat.startcode.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Person {
    private String email;
    private String address;
    private String name;
    private String phonenumber;
    private String city;
    private int zipcode;

    public Person(String email, String address, String name, String phonenumber, String city, int zipcode) {
        this.email = email;
        this.address = address;
        this.name = name;
        this.phonenumber = phonenumber;
        this.city = city;
        this.zipcode = zipcode;
    }
}
