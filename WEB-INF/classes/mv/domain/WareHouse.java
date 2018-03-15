package mv.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import mv.domain.Asset_WareHouse;
import mv.domain.Employee;
import mv.domain.Record;

@Entity
public class WareHouse {
    @Id
    @SequenceGenerator(name="WarehouseSeq", sequenceName="WAREHOUSE_SEQ", allocationSize=1)
    @GeneratedValue(generator="WarehouseSeq", strategy=GenerationType.SEQUENCE)
    long id;
    @Column(name="name", unique=true)
    String name;
    @OneToMany(mappedBy="warehouse", fetch=FetchType.EAGER)
    Set<Asset_WareHouse> asset_warehouses;
    @OneToMany(mappedBy="startWareHouse")
    Set<Record> startRecords;
    @OneToMany(mappedBy="endWareHouse")
    Set<Record> endRecords;
    @OneToMany(mappedBy="warehouse", fetch=FetchType.EAGER)
    Set<Employee> employees;

    public WareHouse(long id, String name, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public WareHouse() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Asset_WareHouse> getAsset_warehouses() {
        return this.asset_warehouses;
    }

    public void setAsset_warehouses(Set<Asset_WareHouse> asset_warehouses) {
        this.asset_warehouses = asset_warehouses;
    }

    public Set<Record> getStartRecords() {
        return this.startRecords;
    }

    public void setStartRecords(Set<Record> startRecords) {
        this.startRecords = startRecords;
    }

    public Set<Record> getEndRecords() {
        return this.endRecords;
    }

    public void setEndRecords(Set<Record> endRecords) {
        this.endRecords = endRecords;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String toString() {
        return "WareHouse [id=" + this.id + ", name=" + this.name + "]";
    }
}