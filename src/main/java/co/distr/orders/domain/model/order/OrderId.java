package co.distr.orders.domain.model.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Personal on 03/06/2017.
 */

@Embeddable
public class OrderId implements Serializable{

    @Column(name = "ID")
    private String id;

    protected OrderId(){
        this.id = UUID.randomUUID().toString();
    }

    public String asString(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderId orderId = (OrderId) o;

        return id.equals(orderId.id);
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
