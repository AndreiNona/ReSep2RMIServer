package sep2.contracts;

import sep2.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserDAO {
    //For login
    User getUserByUsername(String username) throws IOException;

    //User accessible functions
    User getUserById(int id);
    List<User> getAllUsers() throws IOException;

    //Normal user functions
    void addUser(User user) ;
    void deleteUserById(int id);
    void updateUser(User user);
}