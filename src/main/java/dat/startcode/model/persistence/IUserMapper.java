package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.SQLException;

public interface IUserMapper
{
    public User login(String email, String kodeord) throws DatabaseException;
    public User createUser(String username, String password, String role) throws DatabaseException;

    void addUserBalance(int balance, User user) throws SQLException;

    void removeUserBalance(int balance, User user) throws SQLException;

    int getUserIDFromEmail(User user) throws SQLException;
}
