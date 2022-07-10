package sep2.models;

import sep2.contracts.AssetModel;
import sep2.entities.Asset;

import java.io.IOException;
import java.util.List;

public class ModelAsset implements AssetModel {
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
