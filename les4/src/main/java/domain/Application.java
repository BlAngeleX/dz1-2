package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        SessionFactory factory = configuration.configure().buildSessionFactory();

        Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();

        ProductCategory category = new ProductCategory();
        category.setName("AVIA");

        session.persist(category);
        // они ПОЧТИ равны
        // session.save(category); - сохранит объект с новым id

        System.out.println(category.getCategoryId() + " " + category.getName());

        transaction.commit();
        //session.close();

        final Transaction transaction1 = session.beginTransaction();
        ProductCategory category1 = session.find(ProductCategory.class, category.getCategoryId());
        System.out.println(category1.getCategoryId() + " " + category1.getName());
        transaction1.commit();
        session.close();

        factory.close();

    }
}
