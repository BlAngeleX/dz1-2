package repository;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductRepositoryImplTest {

    @Mock // так как внешние зависимости
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    private ProductRepository repository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        this.repository = new ProductRepositoryImpl(factory);
    }

    @Test
    public void testCreate() {
        int id = 10;
        String name = "Marker";
        double weight = 0.050d;

        Product result = repository.createProduct(id, name, weight);
        assertEquals(id, result.getProductId());
        assertEquals(name, result.getName());
        assertEquals(weight, result.getWeight(), 0);

        verify(session).persist(Matchers.any(Product.class));
        verify(transaction).commit();
        verify(session).close();

    }

}
