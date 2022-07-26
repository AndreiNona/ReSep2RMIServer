package sep2.daos;

import sep2.contracts.AssetDAO;
import sep2.entities.Asset;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei-Sorin Ioanas
 */
public class AssetDAOImpl implements AssetDAO {
    private static AssetDAOImpl instance;

    /**
     *
     * @throws SQLException
     */
    private AssetDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    /**
     * Singleton used to get only one instance of the database
     * @return instance of the database
     * @throws SQLException
     */
    public static synchronized AssetDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new AssetDAOImpl();
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
     * Main method for looking up assets
     * @param id contains the int value of the assetID to be returned from the database
     * @return Asset item that matches ID with the search parameter, in case of no match returns null
     */
    @Override
    public Asset getAssetById(int id) {
        Asset assetFound = null;

        try(Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM resep2.resep2.asset WHERE id = ?"); //TODO:Change query to fit current DB
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.isBeforeFirst()){
                if (resultSet.next()) {

                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    double value = resultSet.getDouble("value");

                    assetFound = new Asset(id,name,description,value);
                    System.out.println("Product found: " + assetFound.toString());

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null; //If there is no asset to be returned the server will crash
        }

        return assetFound;
    }
    /**
     * Method used for getting all assets from the database
     * @return List of all the assets contained in the database
     * @throws IOException
     */
    @Override
    public List<Asset> getAllAssets() throws IOException {
        List<Asset> assetsFound = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM resep2.resep2.asset WHERE value >= 0");//TODO:Change query to fit current DB
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int assetID = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Double value = resultSet.getDouble("value");
                Asset asset = new Asset(assetID,name, description, value);
                assetsFound.add(asset);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(assetsFound.toString());
        return assetsFound;

    }

    /**
     * Method used for adding assets to the database
     * @param asset Asset to be added to the database (note ID needs to be unique)
     */
    @Override
    public void addAsset(Asset asset) {
        Asset result = null;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO resep2.resep2.asset (name,brand, value) VALUES (?,?, ?)",  PreparedStatement.RETURN_GENERATED_KEYS);//TODO:Change query to fit current DB
            statement.setString(1, asset.getName());
            statement.setString(2, asset.getDescription());
            statement.setDouble(3, asset.getValue());
            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                result = new Asset (keys.getInt(1), asset.getName(), asset.getDescription(), asset.getValue());
            } else {
                throw new SQLException("No key generated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used for deleting assets from the database
     * @param id contains the int value of the asset to be searched and deleted from the database
     */
    @Override
    public void deleteAssetById(int id) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM resep2.resep2.asset WHERE id = ?");//TODO:Change query to fit current DB
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method used to update all data fields in a given asset object
     * @param asset Asset object that replaces the current user entry in the database
     */
    @Override
    public void updateAsset(Asset asset) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE resep2.resep2.asset SET name = ?, brand = ?, value = ? WHERE assetID = ?");//TODO:Change query to fit current DB
            statement.setString(1, asset.getName());
            statement.setString(2, asset.getDescription());
            statement.setDouble(3, asset.getValue());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
