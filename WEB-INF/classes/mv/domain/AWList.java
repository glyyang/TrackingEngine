package mv.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import mv.domain.AssetWareHouse;

@XmlRootElement(name="asset-warehouses")
public class AWList {
    private List<AssetWareHouse> asset_warehouses;

    public AWList() {
    }

    public AWList(List<AssetWareHouse> asset_warehouses) {
        this.asset_warehouses = asset_warehouses;
    }

    public List<AssetWareHouse> getAsset_warehouses() {
        return this.asset_warehouses;
    }

    @XmlElement(name="asset-warehouse")
    public void setAsset_warehouses(List<AssetWareHouse> asset_warehouses) {
        this.asset_warehouses = asset_warehouses;
    }

    public String toString() {
        return "AWList [asset_warehouses=" + this.asset_warehouses + "]";
    }
}