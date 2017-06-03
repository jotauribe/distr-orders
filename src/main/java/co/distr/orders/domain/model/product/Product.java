package co.distr.orders.domain.model.product;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by Personal on 03/06/2017.
 */
@Entity(name = "PRODUCTS")
public class Product {

    @EmbeddedId
    private ProductId id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private double price;

    protected Product(){}

    public Product(ProductId id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
