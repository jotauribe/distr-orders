package co.distr.orders.application.product;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Guess on 16/6/2017.
 */

@XmlRootElement
public class ViewProductRequest {

    private String id;
    private String name;
    private double price;
    private boolean unique;
    private int resultsQuantity;

    public ViewProductRequest(String id, String name, double price, int resultsQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.resultsQuantity = resultsQuantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isUnique() {
        return unique;
    }

    public int getResultsQuantity() {
        return resultsQuantity;
    }
}
