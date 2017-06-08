package co.distr.orders.application;

import co.distr.orders.domain.model.order.OrderRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Guess on 4/6/2017.
 */

@Stateless
public class CreateOrderService {

    @Inject
    OrderRepository orderRepository;

    public void execute(){

    }

}
