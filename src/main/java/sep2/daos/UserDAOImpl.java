package sep2.daos;

import sep2.contracts.UserDAO;
import sep2.entities.Date;
import sep2.entities.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei-Sorin Ioanas
 */
public class UserDAOImpl implements UserDAO {
    private static UserDAOImpl instance;

    /**
     *
     * @throws SQLException
     */
    private UserDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    /**
     * Singleton used to get only one instance of the database
     * @return instance of the database
     * @throws SQLException
     */
    public static synchronized UserDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    /**
     * Method used to connect to postgres (requires in code user and password, that match the existing ones in the running device)
     * @return Connection
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/database_sep2", "postgres", "1234");
    }

    /**
     * Method used for getting a user based on the username. Should only be used at login as the UserID is unavailable, any other search should use UserID if possible
     * @param username string containing a username to be looked up in the database
     * @return User item that matches usernames with the search parameter, in case of no match returns null
     * @throws IOException
     */
    @Override
    public User getUserByUsername(String username) throws IOException {
        User userFound = null;
        System.out.println(username);

        try(Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM resep2.resep2.Client WHERE username = ?");//TODO:Change query to fit current DB
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
                    //Query needs to be done from a joint table
                    //Consider making a table of available dates with a foreign key of the User and trainer ID assigned to it (all dates are assigned a trainer by default, unsure how to do when it comes to users)
                    List<Date> tSes = new ArrayList<>();
                    char gender = resultSet.getString("gender").charAt(0); //Probably does not work
                    String address  = resultSet.getString("address");
                    String zipCode  = resultSet.getString("zipCode");
                    userFound = new User(userID, username, password, isAdmin, fName, lName, gender, phone,tSes, email, address, zipCode);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null; //If there is no user to be returned the server will crash
        }

        System.out.println(userFound.toString());
        return userFound;
    }

    /**
     * Main method for looking up users
     * @param id contains the int value of the userID to be returned from the database
     * @return User item that matches ID with the search parameter, in case of no match returns null
     */
    @Override
    public User getUserById(int id) {
        User userFound = null;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM resep2.resep2.Client WHERE username = ?");//TODO:Change query to fit current DB
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
                    //Query needs to be done from a joint table
                    List<Date> tSes = new ArrayList<>();
                    char gender = resultSet.getString("gender").charAt(0); //Probably does not work
                    String address  = resultSet.getString("address");
                    String zipCode  = resultSet.getString("zipCode");
                    userFound = new User(userID, userName, password, isAdmin, fName, lName, gender, phone,tSes, email, address, zipCode);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; //If there is no user to be returned the server will crash
        }

        return userFound;
    }

    /**
     * Method used for getting all users from the database
     * @return List of all the users contained in the database
     * @throws IOException
     */
    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> usersFound = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM resep2.resep2.users");//TODO:Change query to fit current DB
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int userID = resultSet.getInt("id");
                String userName = resultSet.getString("username");//Maybe remove?
                String password = resultSet.getString("password");//Maybe remove?
                boolean isAdmin = resultSet.getBoolean("isAdmin");//Maybe remove?
                String fName = resultSet.getString("fName");
                String lName = resultSet.getString("lName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                //Query needs to be done from a joint table
                List<Date> tSes = new ArrayList<>();
                char gender = resultSet.getString("gender").charAt(0); //Probably does not work
                String address  = resultSet.getString("address");
                String zipCode  = resultSet.getString("zipCode");
                User user = new User(userID, userName, password, isAdmin, fName, lName, gender, phone,tSes, email, address, zipCode);
                System.out.println(user.toString());
                usersFound.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(usersFound.toString());
        return usersFound;
    }

    /**
     * Method used for adding users to the database
     * @param user User to be added to the database (note ID needs to be unique)
     */
    @Override
    public void addUser(User user) {
        User result = null;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO resep2.resep2.users (username,password,isAdmin, fName, lName, email,phone,gender,address,zipCode) VALUES (?,?,?,?,?,?,?,?,?,?)",  PreparedStatement.RETURN_GENERATED_KEYS);//TODO:Change query to fit current DB
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, user.isAdmin());
            statement.setString(4, user.getFirstNane());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getPhoneNumber());

            //Query needs to be done from a joint table
            List<Date> tSes = new ArrayList<>();

            statement.setString(8, String.valueOf(user.getGender())); //Consider changing
            statement.setString(9, user.getAddress());
            statement.setString(10, user.getZipcode());
            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                result = new User (keys.getInt(1), user.getUsername(), user.getPassword(), user.isAdmin(), user.getFirstNane(), user.getLastName(), user.getGender(),user.getPhoneNumber(),tSes,user.getEmail(),user.getAddress(), user.getZipcode());
            } else {
                throw new SQLException("No key generated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used for deleting users from the database
     * @param id contains the int value of the user to be searched and deleted from the database
     */
    @Override
    public void deleteUserById(int id) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM resep2.resep2.user WHERE id = ?");//TODO:Change query to fit current DB
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used to update all data fields in a given user object
     * @param user User object that replaces the current user entry in the database
     */
    @Override
    public void updateUser(User user) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE resep2.resep2.users SET username = ?,password = ?,isAdmin = ?, fName = ?, lName = ?, email = ?,phone = ?,gender = ?,address = ?,zipCode = ? WHERE userID = ?");//TODO:Change query to fit current DB
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, user.isAdmin());
            statement.setString(4, user.getFirstNane());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getPhoneNumber());

            //Query needs to be done from a joint table
            List<Date> tSes = new ArrayList<>();

            statement.setString(8, String.valueOf(user.getGender())); //Consider changing
            statement.setString(9, user.getAddress());
            statement.setString(10, user.getZipcode());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
