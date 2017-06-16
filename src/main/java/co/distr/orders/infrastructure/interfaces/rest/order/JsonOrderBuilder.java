package co.distr.orders.infrastructure.interfaces.rest.order;

import co.distr.orders.domain.model.order.Order;
import co.distr.orders.domain.model.order.OrderItem;

import javax.json.*;
import java.util.List;

/**
 * Created by Guess on 16/6/2017.
 */
public class JsonOrderBuilder {

    public static JsonObject buildOrder(Order order){
        String orderId = order.getOrderId().toString();
        String creationDate = order.getDate().toString();
        String status = order.getOrderStatus().toString();
        List<OrderItem> orderItems = order.getOrderItems();

        return Json.createObjectBuilder().add("order", Json.createObjectBuilder()
                .add("getOrderId", orderId)
                .add("getDate", creationDate)
                .add("status",status)
                .add("items", buildOrderItems(orderItems)))
                .build();
    }

    public static JsonArray buildOrderItems(List<OrderItem> orderItems){
        return orderItems.stream()
                .map(item -> {
                    return Json.createObjectBuilder()
                            .add("getOrderId",item.id())
                            .add("getProduct",Json.createObjectBuilder()
                                    .add("product_name", item.productName())
                                    .add("product_price", item.productPrice()))
                            .add("getQuantity", item.getQuantity())
                            .build();
                }).collect(
                        Json::createArrayBuilder,
                        JsonArrayBuilder::add,
                        JsonArrayBuilder::add
                ).build();
    }

}
