package sep2.entities;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    //For system
    private int trainerID;
    private String username;
    private String password;
    private boolean isAdmin;

    //Contact
    private String email;
    private List<Date> scheduled;


    public Trainer() {
    }

    public Trainer(int trainerID, String username, String password, boolean isAdmin) {
        this.trainerID = trainerID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.scheduled = new ArrayList<>();
    }

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
