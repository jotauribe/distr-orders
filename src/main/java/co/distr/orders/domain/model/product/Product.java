package co.distr.orders.domain.model.product;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Created by Jota Uribe on 03/06/2017.
 */

@XmlRootElement
@Entity(name = "PRODUCTS")
@NamedQueries({
        @NamedQuery(name = "Product.findByProductId",
                query = "Select p from PRODUCTS p where p.productId = :ProductId"),
        @NamedQuery(name = "Product.findByProductName",
                query = "Select p from PRODUCTS p where SUBSTRING(p.productId, 0) = :String"),
        @NamedQuery(name = "Product.findAll",
                query = "Select p from PRODUCTS p")
})
public class Product {

    @EmbeddedId
    private ProductId productId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private double price;

    protected Product(){}

    public Product(ProductId productId, String name, double price){
        this.productId = productId;
        setName(name);
        setPrice(price);
    }

    private void setName(String name){
        if(name == null)
            throw  new IllegalArgumentException("Name can not be null");
        if(name.length() < 5)
            throw  new IllegalArgumentException("Name length must be greater than 4");
        this.name = name;
    }

    private void setPrice(double price){
        if(price < 0)
            throw  new IllegalArgumentException("Price can not be a negative number");
        this.price = price;
    }

    @XmlElement
    public ProductId id(){
        return productId;
    }

    @XmlElement
    public String name() {
        return name;
    }

    @XmlElement
    public double price() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productId.equals(product.productId);
    }

    @Override
    public int hashCode() {
        return productId.hashCode();
    }
}
