package entities;

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

    //Contact
    private String email;
    private String address;
    private int zipcode;

    public User() {
    }

    public User(int userID, String username, String password, boolean isAdmin) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(int userID, String username, String password, boolean isAdmin , String firstNane, String lastName, char gender, String phoneNumber) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.firstNane = firstNane;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public User(int userID, String username, String password,boolean isAdmin, String firstNane, String lastName, char gender, String phoneNumber, String email, String address, int zipcode) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.firstNane = firstNane;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
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
        this.gender = gender;
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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
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
