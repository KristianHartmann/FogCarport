package dat.startcode.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter @Setter
public class User {
    private int user_id;
    private String role;
    private int balance;
    private String password;
    private String email;

    public User(int user_id, String role, int balance, String password, String email) {
        this.user_id = user_id;
        this.role = role;
        this.balance = balance;
        this.password = password;
        this.email = email;
    }
    public User(String role, String password, String email) {
        this.role = role;
        this.balance = 0;
        this.password = password;
        this.email = email;
    }

    public User(String email) {
        this.email = email;
    }
}
