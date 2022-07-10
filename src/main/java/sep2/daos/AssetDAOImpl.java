package sep2.daos;

import sep2.contracts.AssetDAO;
import sep2.entities.Asset;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class AssetDAOImpl implements AssetDAO {
    private static AssetDAOImpl instance;

    private AssetDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized AssetDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new AssetDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/database_sep2", "postgres", "1234");
    }

    @Override
    public Asset getAssetById(int id) {
        return null;
    }

    @Override
    public List<Asset> getAllAssets() throws IOException {
        return null;
    }

    @Override
    public void addAsset(Asset asset) {

    }

    @Override
    public void deleteAssetById(int id) {

    }

    @Override
    public void updateAsset(Asset asset) {

    }
}
