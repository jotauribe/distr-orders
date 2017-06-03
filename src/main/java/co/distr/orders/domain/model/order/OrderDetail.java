package co.distr.orders.domain.model.order;

import co.distr.orders.domain.model.product.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by Personal on 03/06/2017.
 */

@Entity(name = "ORDERDETAILS")
public class OrderDetail {

    @OneToOne
    private Product product;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "SUBTOTAL")
    private double subTotal;

    protected OrderDetail(){}


    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
