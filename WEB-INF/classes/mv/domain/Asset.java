package mv.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Asset
{
  @javax.persistence.Id
  @SequenceGenerator(name="AssetSeq", sequenceName="ASSET_SEQ", allocationSize=1)
  @GeneratedValue(generator="AssetSeq", strategy=GenerationType.SEQUENCE)
  long id;
  @Column(name="name", unique=true)
  String name;
  @Column(name="price")
  float price;
  @OneToMany(mappedBy="asset", fetch=FetchType.EAGER)
  Set<Sub_Record> sub_records;
  @OneToMany(mappedBy="asset", fetch=FetchType.EAGER)
  Set<Asset_WareHouse> asset_warehouses;
  
  public Asset(long id, String name, float price)
  {
    this.id = id;
    this.name = name;
    this.price = price;
  }
  

  public Asset() {}
  

  public long getId()
  {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public float getPrice() {
    return price;
  }
  
  public void setPrice(float price) {
    this.price = price;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Set<Sub_Record> getSub_records() {
    return sub_records;
  }
  
  public void setSub_records(Set<Sub_Record> sub_records) {
    this.sub_records = sub_records;
  }
  
  public Set<Asset_WareHouse> getAsset_warehouses() {
    return asset_warehouses;
  }
  
  public void setAsset_warehouses(Set<Asset_WareHouse> asset_warehouses) {
    this.asset_warehouses = asset_warehouses;
  }
  
  public String toString()
  {
    return 
      "Asset [id=" + id + ", name=" + name + ", price=" + price + "]";
  }
}