package sep2.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei-Sorin Ioanas
 */
public class Equipment {
    private String name;
    private String description;
    private List<Date>bookedDays;

    public Equipment() {
    }

    public Equipment(String name, String description) {
        this.name = name;
        this.description = description;
        this.bookedDays = new ArrayList<>();
    }

    public Equipment(String name, String description, List<Date> bookedDays) {
        this.name = name;
        this.description = description;
        this.bookedDays = bookedDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Date> getBookedDays() {
        return bookedDays;
    }

    public void setBookedDays(List<Date> bookedDays) {
        this.bookedDays = bookedDays;
    }
}
