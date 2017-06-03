package co.distr.orders.domain.model.product;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Personal on 03/06/2017.
 */
public class ProductTest {

    @Test
    public void equalsTest(){

        ProductId pid = new ProductId();
        Product p1 = new Product(pid, "nombre", 34);
        Product p2 = new Product(pid, "otroNombre", 36);
        assertEquals(p1, p2);
    }

    @Test
    public void notEqualsTest(){

        ProductId pid1 = new ProductId();
        ProductId pid2 = new ProductId();
        Product p1 = new Product(pid1, "nombre", 34);
        Product p2 = new Product(pid2, "nombre", 36);

        assertNotSame(p1, p2);
    }


}