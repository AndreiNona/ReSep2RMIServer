package sep2.entities;

public class Asset {

    private int assetID;

    private String name;
    private String description;

    private double value;

    public Asset() {
    }

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
