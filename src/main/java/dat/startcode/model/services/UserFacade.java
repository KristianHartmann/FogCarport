package dat.startcode.model.services;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;
import lombok.SneakyThrows;

import java.util.ArrayList;

public class UserFacade {

    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        UserMapper userMapper = new UserMapper(connectionPool);
        return userMapper.login(username, password);
    }

    public static User createUser(String email, String password, String role, ConnectionPool connectionPool) throws DatabaseException {
        UserMapper userMapper = new UserMapper(connectionPool);
        return userMapper.createUser(email, password, role);
    }

    @SneakyThrows
    public static ArrayList<User> getAllUsers(ConnectionPool connectionPool) {
        UserMapper userMapper = new UserMapper(connectionPool);
        return userMapper.getAllUsers();

    }

    @SneakyThrows
    public static void removeBalanace(ConnectionPool connectionPool, int money, User user) {
        UserMapper userMapper = new UserMapper(connectionPool);
        userMapper.removeUserBalance(money, user);
    }

    @SneakyThrows
    public static int getUserIDFromEmail(ConnectionPool connectionPool, User user) {
        UserMapper userMapper = new UserMapper(connectionPool);
        return userMapper.getUserIDFromEmail(user);
    }
}
