package co.distr.orders.application.order;

import co.distr.orders.domain.model.order.OrderItem;

import java.util.List;

/**
 * Created by Guess on 15/6/2017.
 */
public class CreateOrderRequest {

    private String clientId;
    private List<OrderItem> orderItems;

    public CreateOrderRequest(String clientId, List<OrderItem> orderItems){
        this.clientId = clientId;
        this.orderItems = orderItems;
    }

    public String clientId() {
        return clientId;
    }

    public List<OrderItem> orderItems() {
        return orderItems;
    }
}
