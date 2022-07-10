package sep2.contracts;

import sep2.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserModel {

    //For login
    User getUserByUsername(String username) throws IOException;

    //User accessible functions
    User getUserById(int id);
    List<User> getAllUsers() throws IOException;

    //Admin asset functions
    void addUser(User user) ;
    void deleteUserById(int id);
    void updateUser(User user);

}
