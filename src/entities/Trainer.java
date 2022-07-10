package entities;

public class Trainer {

    //For system
    private int trainerID;
    private String username;
    private String password;
    private boolean isAdmin;

    private String email;
    private Sheduel sheduel;

    public Trainer() {
    }

    public Trainer(int trainerID, String username, String password, boolean isAdmin) {
        this.trainerID = trainerID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.sheduel = new Sheduel();
    }

    public Trainer(int trainerID, String username, String password, boolean isAdmin, String email, Sheduel sheduel) {
        this.trainerID = trainerID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.email = email;
        this.sheduel = sheduel;
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

    public Sheduel getSheduel() {
        return sheduel;
    }

    public void setSheduel(Sheduel sheduel) {
        this.sheduel = sheduel;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerID=" + trainerID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", email='" + email + '\'' +
                ", sheduel=" + sheduel +
                '}';
    }
}
