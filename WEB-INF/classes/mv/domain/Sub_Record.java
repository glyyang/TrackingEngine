package mv.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import mv.domain.Asset;
import mv.domain.Record;

@Entity
public class Sub_Record {
    @Id
    @SequenceGenerator(name="SubRecordSeq", sequenceName="SUB_RECORD_SEQ", allocationSize=1)
    @GeneratedValue(generator="SubRecordSeq", strategy=GenerationType.SEQUENCE)
    long id;
    @Column(name="asset_quantity")
    long quantity;
    @ManyToOne(cascade={CascadeType.ALL})
    Record record;
    @ManyToOne
    Asset asset;

    public Sub_Record(long id, long quantity, Record record, Asset asset) {
        this.id = id;
        this.quantity = quantity;
        this.record = record;
        this.asset = asset;
    }

    public Sub_Record(long quantity, Record record, Asset asset) {
        this.quantity = quantity;
        this.record = record;
        this.asset = asset;
    }

    public Sub_Record() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Record getRecord() {
        return this.record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Asset getAsset() {
        return this.asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public String toString() {
        return "Sub_Record [id=" + this.id + ", quantity=" + this.quantity + ", record=" + this.record + ", asset=" + this.asset + "]";
    }
}