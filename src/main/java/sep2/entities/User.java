package sep2.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei-Sorin Ioanas
 * Object used to store information about the customers
 */
public class User {

    //For system
    private int userID;
    private String username;
    private String password;
    private boolean isAdmin;

    //About user
    private String firstNane;
    private String lastName;
    private char gender;
    private String phoneNumber;
    private List<Date> trainingSessions;

    //Contact
    private String email;
    private String address;
    private String zipcode;

    /**
     * Empty constructor
     */
    public User() {
    }

    /**
     * Minimum constructor
     * @param userID int of unique ID of a user (for database lookup)
     * @param username string Username for logging in
     * @param password string Password for logging in
     * @param isAdmin boolean value determining if the user is an admin or not (feature only used for testing privileges but should be expanded for premium users)
     */
    public User(int userID, String username, String password, boolean isAdmin) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.trainingSessions =new ArrayList<>();
    }

    /**
     * Constructor including user details
     * @param userID int of unique ID of a user (for database lookup)
     * @param username string Username for logging in
     * @param password string Password for logging in
     * @param isAdmin boolean value determining if the user is an admin or not (feature only used for testing privileges but should be expanded for premium users)
     * @param firstNane string of the first name of the user
     * @param lastName string of the last name of the user
     * @param gender char denoting the gender of the user
     * @param phoneNumber string of the phone number of the user
     * @param trainingSessions list of dates where the user has booked appointments
     */
    public User(int userID, String username, String password, boolean isAdmin , String firstNane, String lastName, char gender, String phoneNumber,List<Date> trainingSessions) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.firstNane = firstNane;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.trainingSessions = trainingSessions;
    }

    /**
     * Complete constructor, including contact details
     * @param userID int of unique ID of a user (for database lookup)
     * @param username string Username for logging in
     * @param password string Password for logging in
     * @param isAdmin boolean value determining if the user is an admin or not (feature only used for testing privileges but should be expanded for premium users)
     * @param firstNane string of the first name of the user
     * @param lastName string of the last name of the user
     * @param gender char denoting the gender of the user
     * @param phoneNumber string of the phone number of the user
     * @param trainingSessions list of dates where the user has booked appointments
     * @param email string of the email associated with the user
     * @param address string of the address associated with the user
     * @param zipcode string of the zipcode associated with the user
     */
    public User(int userID, String username, String password,boolean isAdmin, String firstNane, String lastName, char gender, String phoneNumber,List<Date> trainingSessions, String email, String address, String zipcode) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.firstNane = firstNane;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.trainingSessions =trainingSessions;
        this.email = email;
        this.address = address;
        this.zipcode = zipcode;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getFirstNane() {
        return firstNane;
    }

    public void setFirstNane(String firstNane) {
        this.firstNane = firstNane;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        switch (gender){
            case 'm','M':
                this.gender='M';
                break;
            case 'f','F':
                this.gender='F';
                break;
            default:
                System.out.println("Expected: M/F given argument: "+gender);
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Admin='" + isAdmin + '\'' +
                ", firstNane='" + firstNane + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
