package mv.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="asset")
public class RAsset {
    long id;
    String name;
    float price;

    public RAsset(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public RAsset() {
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
    public float getPrice() {
        return this.price;
    }

    @XmlElement
    public void setPrice(float price) {
        this.price = price;
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
        return "Asset [id=" + this.id + ", name=" + this.name + ", price=" + this.price + "]";
    }
}