package dat.startcode.model.entities;

import java.util.Objects;

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
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
