package co.distr.orders.application.order;

import co.distr.orders.domain.model.client.ClientId;
import co.distr.orders.domain.model.order.Order;
import co.distr.orders.domain.model.order.OrderId;
import co.distr.orders.domain.model.order.OrderItem;
import co.distr.orders.domain.model.order.OrderRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Guess on 4/6/2017.
 */

@Stateless
public class CreateOrderService {

    @Inject
    OrderRepository orderRepository;

    public Order execute(CreateOrderRequest request){
        Order order = new Order(new OrderId(), new ClientId( request.clientId() ));
        List<OrderItem> orderItems = request.orderItems();

        for (OrderItem orderItem : orderItems) {
            order.addItem(orderItem);
        }

        this.orderRepository.save(order);

        return order;
    }

}
