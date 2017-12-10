package repository;

@FunctionalInterface    // можно использовать как lambda
public interface TransactionOperation {

    Object doInTransaction();

}
