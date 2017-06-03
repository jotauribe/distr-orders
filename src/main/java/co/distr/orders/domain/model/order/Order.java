package co.distr.orders.domain.model.order;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Personal on 03/06/2017.
 */
@Entity(name = "ORDERS")
public class Order {

    @EmbeddedId
    private OrderId id;

    @Column(name = "DATE")
    private Date date;

    @OneToMany
    private List<OrderDetail> ordersDetails;

    @Column(name = "TOTAL")
    private double total;


}
