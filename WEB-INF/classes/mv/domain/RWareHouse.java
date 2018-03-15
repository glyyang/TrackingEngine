package mv.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="warehouse")
public class RWareHouse {
    long id;
    String name;

    public RWareHouse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RWareHouse() {
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
    public String getName() {
        return this.name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "WareHouse [id=" + this.id + ", name=" + this.name + "]";
    }
}