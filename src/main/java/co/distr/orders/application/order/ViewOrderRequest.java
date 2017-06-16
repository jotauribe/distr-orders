package co.distr.orders.application.order;

/**
 * Created by Guess on 16/6/2017.
 */
public class ViewOrderRequest {
    private String orderId;

    public ViewOrderRequest(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
