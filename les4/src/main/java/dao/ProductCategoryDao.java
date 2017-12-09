package dao;

/**
 * Created by admin on 04.12.2017.
 */
public interface ProductCategoryDao { //dao - data access object
    ProductCategory create(String name);
    void getAll();
}
