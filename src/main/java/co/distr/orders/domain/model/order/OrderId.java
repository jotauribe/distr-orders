package co.distr.orders.domain.model.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

/**
 * Created by Personal on 03/06/2017.
 */

@Embeddable
public class OrderId {

    @Column(name = "ID")
    private String id;

    public OrderId(){
        this.id = UUID.randomUUID().toString();
    }

}
