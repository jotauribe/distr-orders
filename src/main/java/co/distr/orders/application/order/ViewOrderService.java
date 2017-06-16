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
 * Created by Guess on 16/6/2017.
 */
@Stateless
public class ViewOrderService {

    @Inject
    OrderRepository orderRepository;

    public Order execute(ViewOrderRequest request){

        return orderRepository.find( new OrderId(request.getOrderId()));

    }

}
