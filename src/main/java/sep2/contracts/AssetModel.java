package sep2.contracts;

import sep2.entities.Asset;

import java.io.IOException;
import java.util.List;

public interface AssetModel {

    //User asset functions
    Asset getAssetById(int id);

    List<Asset> getAllAssets() throws IOException;

    //Admin asset functions
    void addAsset(Asset asset) ;
    void deleteAssetById(int id);
    void updateAsset(Asset asset);
}
