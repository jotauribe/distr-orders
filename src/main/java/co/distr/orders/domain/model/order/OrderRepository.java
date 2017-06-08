package co.distr.orders.domain.model.order;

import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Jota on 4/6/2017.
 */
@javax.faces.bean.ApplicationScoped
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    protected OrderRepository(){}

    public void save(Order order){
        entityManager.persist(order);
    }

    public Order find(OrderId orderId){
        return entityManager.createNamedQuery("Order.findByOrderId",
                Order.class).setParameter("OrderId", orderId)
                .getSingleResult();
    }




}
