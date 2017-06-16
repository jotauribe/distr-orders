package co.distr.orders.domain.model.product;

import co.distr.orders.domain.model.order.Order;
import co.distr.orders.domain.model.order.OrderId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Guess on 16/6/2017.
 */
@ApplicationScoped
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    protected ProductRepository(){}

    public void save(Product product){
        entityManager.persist(product);
    }

    public Product find(ProductId productId){
        return entityManager.createNamedQuery(
                "Product.findByProductId",
                Product.class)
                .setParameter("ProductId", productId)
                .getSingleResult();
    }

    public List<Product> findAll(){
        return entityManager.createNamedQuery(
                "Product.findAll",
                Product.class)
                .getResultList();
    }

    public List<Product> findByName(String string){

        return  entityManager.createNamedQuery(
                "Product.findByProductName",
                Product.class)
                .setParameter("String", string)
                .getResultList();
    }

}
