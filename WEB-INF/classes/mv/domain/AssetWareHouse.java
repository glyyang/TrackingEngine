package mv.domain;

import javax.xml.bind.annotation.XmlElement;
import mv.domain.RAsset;
import mv.domain.RWareHouse;

public class AssetWareHouse {
    long id;
    long asset_quantity;
    RAsset asset;
    RWareHouse warehouse;

    public AssetWareHouse(long id, long asset_quantity) {
        this.id = id;
        this.asset_quantity = asset_quantity;
    }

    public AssetWareHouse() {
    }

    @XmlElement
    public long getId() {
        return this.id;
    }

    @XmlElement
    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public long getAsset_quantity() {
        return this.asset_quantity;
    }

    @XmlElement
    public void setAsset_quantity(long asset_quantity) {
        this.asset_quantity = asset_quantity;
    }

    @XmlElement
    public RAsset getAsset() {
        return this.asset;
    }

    @XmlElement
    public void setAsset(RAsset asset) {
        this.asset = asset;
    }

    @XmlElement
    public RWareHouse getWarehouse() {
        return this.warehouse;
    }

    @XmlElement
    public void setWarehouse(RWareHouse warehouse) {
        this.warehouse = warehouse;
    }

    public String toString() {
        return "Asset_WareHouse [id=" + this.id + ", asset_quantity=" + this.asset_quantity + ", asset=" + (Object)this.asset + ", warehouse=" + (Object)this.warehouse + "]";
    }
}