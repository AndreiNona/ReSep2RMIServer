package sep2.daos;

import sep2.contracts.UserDAO;
import sep2.entities.User;

import java.io.IOException;
import java.sql.*;
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
        User userFound = null;
        System.out.println(username);

        try(Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM resep2.resep2.Client WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.isBeforeFirst()){

                if (resultSet.next()) {
                    int userID = resultSet.getInt("id");
                    String password = resultSet.getString("password");//Maybe remove?
                    boolean isAdmin = resultSet.getBoolean("isAdmin");//Maybe remove?
                    String fName = resultSet.getString("fName");
                    String lName = resultSet.getString("lName");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    char gender = resultSet.getString("gender").charAt(0); //Probably does not work
                    String address  = resultSet.getString("address");
                    String zipCode  = resultSet.getString("zipCode");
                    userFound = new User(userID, username, password, isAdmin, fName, lName, gender, phone, email, address, zipCode);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(userFound.toString());
        return userFound;
    }

    @Override
    public User getUserById(int id) {
        User userFound = null;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM resep2.resep2.Client WHERE username = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.isBeforeFirst()){
                if (resultSet.next()) {
                    int userID = resultSet.getInt("id");
                    String userName = resultSet.getString("username");//Maybe remove?
                    String password = resultSet.getString("password");//Maybe remove?
                    boolean isAdmin = resultSet.getBoolean("isAdmin");//Maybe remove?
                    String fName = resultSet.getString("fName");
                    String lName = resultSet.getString("lName");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    char gender = resultSet.getString("gender").charAt(0); //Probably does not work
                    String address  = resultSet.getString("address");
                    String zipCode  = resultSet.getString("zipCode");
                    userFound = new User(userID, userName, password, isAdmin, fName, lName, gender, phone, email, address, zipCode);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userFound;
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
