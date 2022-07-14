package sep2.models;

import sep2.contracts.UserModel;
import sep2.daos.UserDAOImpl;
import sep2.entities.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//Proxi from network to UserDAO
public class ModelUser implements UserModel {
    private UserDAOImpl userDAO;
    {
        try {
            userDAO = UserDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    //As a user, I want to be able to create my own account
    @Override
    public void addUser(User user) {
    userDAO.addUser(user);
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public void updateUser(User user) {

    }

}
