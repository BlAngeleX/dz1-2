package repository;

import config.TestHibernateConfiguration;
import domain.Product;
//import org.junit.Assert;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProductRepositoryIT { // integration tests

    private static ProductRepository repository;

    @BeforeClass
    public static void setupOnce() {
        repository = new ProductRepositoryImpl(TestHibernateConfiguration.getFactory());
    }

    @Test
    public void testCreate() {
        int id = 10;
        String name = "Marker";
        double weight = 0.05d;

        final Product result = repository.createProduct(id, name, weight);
        assertEquals(id, result.getProductId());
        assertEquals(name, result.getName());
        assertEquals(weight, result.getWeight(), 0);
    }

    @Test
    public void testFindById_entityExists() {
        int id = 15;
        String name = "Laptop";
        double weight = 3.54d;

        final Product p = repository.createProduct(id, name, weight);
        Product product = repository.findById(id);

        assertEquals(id, product.getProductId());
        assertEquals(name, product.getName());
        assertEquals(weight, product.getWeight(), 0);

    }

    @Test
    public void testFindById_entityNotExists() {}

    @Test
    public void testRemove() {
        int id = 20;
        repository.createProduct(id, "Phone", 0.123d);

        int result = repository.remove(id);
        assertEquals(1, result);

        Product product = repository.findById(id);
        assertNull(product);
    }

    @Test
    public void testRemove_noEntityWithId_returnZero() {
        int result = repository.remove(5);
        assertEquals(0, result);
    }
}
