package co.distr.orders.domain.model.order;

import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Guess on 4/6/2017.
 */
@ApplicationScoped
public class OrderRepository {

    @PersistenceContext(unitName = "MySQLPersistenceUnit")
    private EntityManager entityManager;

    protected OrderRepository(){}

    public void save(Order order){
        entityManager.persist(order);
    }

    public Order OrderOfId(){
        //TODO: Implement
        return null;
    }




}
