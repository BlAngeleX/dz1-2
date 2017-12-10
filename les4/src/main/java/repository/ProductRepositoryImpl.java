package repository;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductRepositoryImpl implements ProductRepository{

    private final SessionFactory factory;

    public ProductRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Product createProduct(int id, String name, double weight) {

        final Product product = new Product(); // неизменяемая ссылка
        product.setProductId(id);
        product.setName(name);
        product.setWeight(weight);

        final Session session = factory.openSession();
//        final Transaction transaction = session.beginTransaction();
//        session.persist(product);
//        transaction.commit();
//        session.close();

        doInTransaction(session, () -> {
            session.persist(product);
            return product;
        }); // lambda-функция
        return product;
    }

    @Override
    public Product findById(int id) {
        final Session session = factory.openSession();
        return (Product) doInTransaction(session, () -> {
            return session.find(Product.class, id);
        });
    }


    @Override
    public int remove(int id) {
        final Session session = factory.openSession();
        return (Integer) doInTransaction(session, () -> {
            return session.createQuery("DELETE FROM Product WHERE productId = :productId")
                    .setParameter("productId", id).executeUpdate();
        });
    }


    private Object doInTransaction(Session session, TransactionOperation operation) {

        final Transaction transaction = session.beginTransaction();

        Object result = operation.doInTransaction();

        transaction.commit();
        session.close();
        return result;

    }

}
