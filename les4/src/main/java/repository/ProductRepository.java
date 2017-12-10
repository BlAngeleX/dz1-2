package repository;

import domain.Product;

public interface ProductRepository {

    Product createProduct(int id, String name, double weight);
    Product findById(int id);
    int remove(int id);
}
