package mv.domain;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import mv.domain.Employee;
import mv.domain.Sub_Record;
import mv.domain.WareHouse;

@Entity
public class Record {
    @Id
    @SequenceGenerator(name="RecordSeq", sequenceName="RECORD_SEQ", allocationSize=1)
    @GeneratedValue(generator="RecordSeq", strategy=GenerationType.SEQUENCE)
    long id;
    @Column(name="is_commit")
    boolean isCommit;
    @Column(name="delivery_destination")
    String destination;
    @Column(name="date_out")
    Date dateOut;
    @Column(name="date_commit")
    Date dateCommit;
    @ManyToOne
    WareHouse startWareHouse;
    @ManyToOne
    WareHouse endWareHouse;
    @ManyToOne
    Employee employee;
    @OneToMany(mappedBy="record", fetch=FetchType.EAGER, cascade={CascadeType.ALL})
    Set<Sub_Record> sub_record;

    public Record(long id, Date dateOut) {
        this.id = id;
        this.dateOut = dateOut;
    }

    public Record() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isCommit() {
        return this.isCommit;
    }

    public void setCommit(boolean isCommit) {
        this.isCommit = isCommit;
    }

    public Date getDateOut() {
        return this.dateOut;
    }

    public void setDateOut(Date date) {
        this.dateOut = date;
    }

    public Date getDateCommit() {
        return this.dateCommit;
    }

    public void setDateCommit(Date dateCommit) {
        this.dateCommit = dateCommit;
    }

    public WareHouse getStartWareHouse() {
        return this.startWareHouse;
    }

    public void setStartWareHouse(WareHouse startWareHouse) {
        this.startWareHouse = startWareHouse;
    }

    public WareHouse getEndWareHouse() {
        return this.endWareHouse;
    }

    public void setEndWareHouse(WareHouse endWareHouse) {
        this.endWareHouse = endWareHouse;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Sub_Record> getSub_record() {
        return this.sub_record;
    }

    public void setSub_record(Set<Sub_Record> sRecs) {
        this.sub_record = sRecs;
    }

    public String toString() {
        return "Record [id=" + this.id + ", isCommit=" + this.isCommit + ", destination=" + this.destination + ", dateOut=" + this.dateOut + ", dateCommit=" + this.dateCommit + ", startWareHouse=" + (Object)this.startWareHouse + ", endWareHouse=" + (Object)this.endWareHouse + ", employee=" + this.employee + ", sub_record=" + this.sub_record + "]";
    }
}