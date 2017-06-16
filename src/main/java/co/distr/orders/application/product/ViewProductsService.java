package co.distr.orders.application.product;

import co.distr.orders.domain.model.product.Product;
import co.distr.orders.domain.model.product.ProductRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Guess on 16/6/2017.
 */
public class ViewProductsService {

    @Inject
    private ProductRepository productRepository;

    public List<Product> execute(){
        return productRepository.findAll();
    }


}
