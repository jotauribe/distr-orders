package co.distr.orders.domain.model.order;

import co.distr.orders.domain.model.client.ClientId;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Personal on 03/06/2017.
 */
@XmlRootElement
@Entity(name = "ORDERS")
@NamedQueries({
        @NamedQuery(name = "Order.findByOrderId",
                query = "Select o from ORDERS o where o.orderId = :OrderId")
})
public class Order {

    @EmbeddedId
    private OrderId orderId;

    @Column(name = "CREATION_DATE")
    private Date date;

    @Column(name = "CLIENT_ID")
    private ClientId clientId;

    @Column(name = "STATUS")
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private List<OrderItem> orderItems;

    @Column(name = "TOTAL")
    private double total;

    protected Order(){
    }

    public Order(OrderId orderId, ClientId clientId){
        this.orderId = orderId;
        this.clientId = clientId;
        this.date = new Date();
        this.orderStatus = OrderStatus.IN_PROCESS;
        this.total = 0;
        this.orderItems = new ArrayList<>();
    }

    public Order(OrderId orderId, ClientId clientId, List<OrderItem> orderItems, double total){
        this.orderId = orderId;
        this.clientId = clientId;
        this.date = new Date();
        this.orderStatus = OrderStatus.IN_PROCESS;
        this.total = total - total;
        for (OrderItem o : orderItems) {
            this.addItem(o);
        }
    }

    @XmlElement
    public OrderId getOrderId(){
        return this.orderId;
    }

    @XmlElement
    public ClientId getClientId() {
        return clientId;
    }

    @XmlElement
    public Date getDate(){
        return new Date(this.date.getTime());
    }

    @XmlElement
    public List<OrderItem> getOrderItems(){
        return this.orderItems;
    }

    @XmlElement
    public OrderStatus getOrderStatus(){
        return this.orderStatus;
    }

    @XmlElement
    public double getTotal() {
        return total;
    }

    public void addItem(OrderItem orderItem){
        if(orderItem == null)
            throw new IllegalArgumentException("Order item can not be null");
        this.orderItems.add(orderItem);
        total += orderItem.getTotal();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return orderId.equals(order.orderId);
    }

    @Override
    public int hashCode() {
        return orderId.hashCode();
    }
}
