package sep2.entities;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Andrei-Sorin Ioanas
 * Object used to store information about the trainer
 */
public class Trainer {

    //For system
    private int trainerID;
    private String username;
    private String password;
    private boolean isAdmin;

    //Contact
    private String email;
    private List<Date> scheduled;

    /**
     * Empty constructor
     */
    public Trainer() {
    }

    /**
     * Minimum constructor
     * @param trainerID int of unique ID of a trainer (for database lookup)
     * @param username string Username for logging in
     * @param password string Password for logging in
     * @param isAdmin boolean value determining if the user is an admin or not (feature only used for testing privileges but should be expanded for premium users)
     */
    public Trainer(int trainerID, String username, String password, boolean isAdmin) {
        this.trainerID = trainerID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.scheduled = new ArrayList<>();
    }

    /**
     * Full consturctor
     * @param trainerID int of unique ID of a trainer (for database lookup)
     * @param username string Username for logging in
     * @param password string Password for logging in
     * @param isAdmin boolean value determining if the user is an admin or not (feature only used for testing privileges but should be expanded for premium users)
     * @param email string of email address associated with the trainer
     * @param scheduled List of the trainer's booked days
     */
    public Trainer(int trainerID, String username, String password, boolean isAdmin, String email, List<Date> scheduled) {
        this.trainerID = trainerID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.email = email;
        this.scheduled = scheduled;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Date> getScheduled() {
        return scheduled;
    }

    public void setScheduled(List<Date> scheduled) {
        this.scheduled = scheduled;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerID=" + trainerID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", email='" + email + '\'' +
                ", scheduled=" + scheduled +
                '}';
    }
}
