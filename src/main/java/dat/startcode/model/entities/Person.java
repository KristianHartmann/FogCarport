package dat.startcode.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
}
