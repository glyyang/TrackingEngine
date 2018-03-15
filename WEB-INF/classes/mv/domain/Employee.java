package mv.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import mv.domain.Record;
import mv.domain.Role;
import mv.domain.WareHouse;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
public class Employee {
    @Id
    @SequenceGenerator(name="EmployeeSeq", sequenceName="EMPLOYEE_SEQ", allocationSize=1)
    @GeneratedValue(generator="EmployeeSeq", strategy=GenerationType.SEQUENCE)
    long id;
    @Column(name="username", unique=true)
    @NotEmpty
    String username;
    @Column(name="password")
    @NotEmpty
    String password;
    @ManyToOne
    Role role;
    @OneToMany(mappedBy="employee")
    Set<Record> records;
    @ManyToOne
    WareHouse warehouse;

    public Employee(String username, String password, WareHouse warehouse) {
        this.username = username;
        this.password = password;
        this.warehouse = warehouse;
    }

    public Employee() {
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
    public String getUsername() {
        return this.username;
    }

    @XmlElement
    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public String getPassword() {
        return this.password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement
    public Role getRole() {
        return this.role;
    }

    @XmlElement
    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Record> getRecords() {
        return this.records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    public WareHouse getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(WareHouse warehouse) {
        this.warehouse = warehouse;
    }

    public String toString() {
        return "Employee [id=" + this.id + ", username=" + this.username + ", password=" + this.password + ", role=" + (Object)this.role + ", records=" + this.records + ", warehouse=" + (Object)this.warehouse + "]";
    }
}