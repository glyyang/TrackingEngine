package mv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Asset_WareHouse
{
  @javax.persistence.Id
  @SequenceGenerator(name="AssetWarehouseSeq", sequenceName="ASSET_WAREHOUSE_SEQ", allocationSize=1)
  @GeneratedValue(generator="AssetWarehouseSeq", strategy=javax.persistence.GenerationType.SEQUENCE)
  long id;
  @Column(name="asset_quantity")
  long asset_quantity;
  @ManyToOne
  Asset asset;
  @ManyToOne
  WareHouse warehouse;
  
  public Asset_WareHouse(long id, long asset_quantity)
  {
    this.id = id;
    this.asset_quantity = asset_quantity;
  }
  

  public Asset_WareHouse() {}
  

  public long getId()
  {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public long getAsset_quantity() {
    return asset_quantity;
  }
  
  public void setAsset_quantity(long asset_quantity) {
    this.asset_quantity = asset_quantity;
  }
  
  public Asset getAsset() {
    return asset;
  }
  
  public void setAsset(Asset asset) {
    this.asset = asset;
  }
  
  public WareHouse getWarehouse() {
    return warehouse;
  }
  
  public void setWarehouse(WareHouse warehouse) {
    this.warehouse = warehouse;
  }
  
  public String toString()
  {
    return 
    
      "Asset_WareHouse [id=" + id + ", asset_quantity=" + asset_quantity + ", asset=" + asset + ", warehouse=" + warehouse + "]";
  }
}