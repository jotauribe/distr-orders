package co.distr.orders.domain.model.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Personal on 03/06/2017.
 */

@Embeddable
@XmlRootElement
public class OrderId implements Serializable{

    @Column(name = "ORDER_ID")
    private String id;

    public OrderId(){
        this.id = UUID.randomUUID().toString();
    }

    public OrderId(String id){
        this.id = id;
    }

    @XmlElement
    public String getId(){
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
