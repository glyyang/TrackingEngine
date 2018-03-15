package mv.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class View_History {
    @Id
    @SequenceGenerator(name="ViewHistorySeq", sequenceName="VIEW_HISTORY_SEQ", allocationSize=1)
    @GeneratedValue(generator="ViewHistorySeq", strategy=GenerationType.SEQUENCE)
    private long id;
    @Column(name="entry_date")
    private Date ent_date;

    public View_History() {
    }

    public View_History(long id, Date ent_date) {
        this.id = id;
        this.ent_date = ent_date;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEnt_date() {
        return this.ent_date;
    }

    public void setEnt_date(Date ent_date) {
        this.ent_date = ent_date;
    }

    public String toString() {
        return "View_History [id=" + this.id + ", ent_date=" + this.ent_date + "]";
    }
}