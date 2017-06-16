package co.distr.orders.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Personal on 03/06/2017.
 */
@Embeddable
@XmlRootElement
public class ProductId implements Serializable{

    @Column(name = "PRODUCT_ID")
    protected String id;

    public ProductId(){
        this.id = UUID.randomUUID().toString();
    }

    @XmlElement
    public String getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductId productId = (ProductId) o;

        return id.equals(productId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id;
    }
}
