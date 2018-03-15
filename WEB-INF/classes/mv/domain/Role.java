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
import javax.xml.bind.annotation.XmlRootElement;
import mv.domain.Employee;

@Entity
@XmlRootElement
public class Role {
    @Id
    @SequenceGenerator(name="RoleSeq", sequenceName="ROLE_SEQ", allocationSize=1)
    @GeneratedValue(generator="RoleSeq", strategy=GenerationType.SEQUENCE)
    long id;
    @Column(name="role_value", unique=true)
    String role_value;
    @OneToMany(mappedBy="role", fetch=FetchType.EAGER)
    Set<Employee> employee;

    public Role(long id, String role_value) {
        this.id = id;
        this.role_value = role_value;
    }

    public Role() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole_value() {
        return this.role_value;
    }

    public void setRole_value(String role_value) {
        this.role_value = role_value;
    }

    public Set<Employee> getEmployee() {
        return this.employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public String toString() {
        return "Role [id=" + this.id + ", role_value=" + this.role_value + ", employee=" + this.employee + "]";
    }
}