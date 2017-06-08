package co.distr.orders.domain.model.order;

import co.distr.orders.domain.model.client.Client;
import co.distr.orders.domain.model.client.ClientId;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Personal on 03/06/2017.
 */
@Entity(name = "ORDERS")
@NamedQueries({
        @NamedQuery(name = "Order.findByOrderId",
                query = "Select o from ORDERS o where o.id = :OrderId")
})
public class Order {

    @EmbeddedId
    private OrderId id;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @OneToMany
    private List<OrderItem> ordersDetails;

    @Column(name = "TOTAL")
    private double total;

    protected Order(){
    }

    public OrderId id(){
        return this.id;
    }

    public Date date(){
        return new Date(this.date.getTime());
    }

}
