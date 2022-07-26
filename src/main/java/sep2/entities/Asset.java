package sep2.entities;
/**
 * @author Andrei-Sorin Ioanas
 * Object used to stor information about sellable items
 */
public class Asset {

    private int assetID;

    private String name;
    private String description;

    private double value;

    /**
     * Empty constructor
     */
    public Asset() {
    }

    /**
     * Full constructor
     * @param assetID int of unique ID of a asset (for database lookup)
     * @param name string containing the name of the sellable asset
     * @param description string containing a short description of the asset
     * @param value double containing the value of the asset
     */
    public Asset(int assetID, String name, String description, double value) {
        this.assetID = assetID;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public int getAssetID() {
        return assetID;
    }

    public void setAssetID(int assetID) {
        this.assetID = assetID;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "assetID=" + assetID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
