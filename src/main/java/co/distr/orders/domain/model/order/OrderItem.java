package co.distr.orders.domain.model.order;

import co.distr.orders.domain.model.product.Product;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Personal on 03/06/2017.
 */

@Entity
@XmlRootElement
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "TOTAL")
    private double total;

    protected OrderItem(){}

    public OrderItem(long id, Product product, double quantity, double total){
        setProduct(product);
        setQuantity(quantity);
        //this.id = id;
    }

    public OrderItem(Product product, double quantity){
        setProduct(product);
        setQuantity(quantity);
    }

    private void setProduct(Product product){
        if(product == null)
            throw new IllegalArgumentException("Product can not be null");
        this.product = product;
    }

    private void setQuantity(double quantity){
        if(quantity <= 0)
            throw new IllegalArgumentException("Quantity cmust be greater than 0");
        this.quantity = (int)quantity;
    }

    @XmlElement
    public long id(){
        return id;
    }

    @XmlElement
    public Product getProduct() {
        return product;
    }

    public String productName(){
        return product.name();
    }

    public String productId(){
        return product.id().toString();
    }

    public double productPrice(){
        return product.price();
    }

    @XmlElement
    public int getQuantity() {
        return quantity;
    }

    @XmlElement
    public double getTotal(){
        return product.price() * this.getQuantity();
    }

    public void changeQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        return id == orderItem.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "getOrderId=" + id +
                ", getProduct=" + product +
                ", getQuantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
