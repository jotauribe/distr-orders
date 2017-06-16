package co.distr.orders.infrastructure.interfaces.rest.order;

import co.distr.orders.application.order.CreateOrderRequest;
import co.distr.orders.application.order.CreateOrderService;
import co.distr.orders.application.order.ViewOrderService;
import co.distr.orders.domain.model.client.ClientId;
import co.distr.orders.domain.model.order.Order;
import co.distr.orders.domain.model.order.OrderId;
import co.distr.orders.domain.model.order.OrderItem;
import co.distr.orders.domain.model.product.Product;
import co.distr.orders.domain.model.product.ProductId;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Guess on 15/6/2017.
 */
@Stateless
@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@XmlRootElement
public class OrderRestService {

    @Inject
    ViewOrderService viewOrderService;

    @Inject
    CreateOrderService createOrderService;

    @GET
    @Path("{id}")
    public Response viewOrder(@PathParam("id") String orderId){
        return Response.ok(mockedOrder(), MediaType.APPLICATION_JSON).build();
    }



    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewOrder(Order order){
         Order addedOrder = this.createOrderService.execute(
                new CreateOrderRequest(
                        order.getClientId().toString(),
                        order.getOrderItems()
                )
        );
        return Response.ok(order, MediaType.APPLICATION_JSON).build();
    }

    private Order mockedOrder(){
        Order order = new Order(new OrderId(), new ClientId());
        order.addItem(new OrderItem(
                new Product(
                        new ProductId(),
                        "producto",
                        89),
                90));

        return order;
    }

}
