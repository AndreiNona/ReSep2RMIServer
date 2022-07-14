package sep2.models;

import sep2.contracts.AssetModel;
import sep2.daos.AssetDAOImpl;
import sep2.entities.Asset;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ModelAsset implements AssetModel {
    private AssetDAOImpl assetDAO;
    {
        try {
            assetDAO = AssetDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Asset getAssetById(int id) {
        return assetDAO.getAssetById(id);
    }

    @Override
    public List<Asset> getAllAssets() throws IOException {
        return assetDAO.getAllAssets();
    }

    @Override
    public void addAsset(Asset asset) {
    assetDAO.addAsset(asset);
    }

    @Override
    public void deleteAssetById(int id) {
    assetDAO.deleteAssetById(id);
    }

    /**
     *  Uses include : book specific assets
     * @param asset asset to be altered
     */
    @Override
    public void updateAsset(Asset asset) {
    assetDAO.updateAsset(asset);
    }
}
