package co.distr.orders.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Personal on 03/06/2017.
 */
@Embeddable
public class ProductId implements Serializable{

    @Column(name = "ID")
    protected String id;

    public ProductId(){
        this.id = UUID.randomUUID().toString();
    }

    public String asString(){
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
}
