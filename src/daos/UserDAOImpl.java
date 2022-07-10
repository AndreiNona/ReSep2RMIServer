package daos;

import contracts.UserDAO;
import entities.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static UserDAOImpl instance;

    private UserDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized UserDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/database_sep2", "postgres", "1234");
    }

    @Override
    public User getUserByUsername(String username) throws IOException {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public void updateUser(User user) {

    }
}
