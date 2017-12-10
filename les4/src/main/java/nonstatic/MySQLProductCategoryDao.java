package nonstatic;

import dao.JdbcUtils;
import dao.ProductCategory;
import dao.ProductCategoryDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by admin on 04.12.2017.
 */
public class MySQLProductCategoryDao implements ProductCategoryDao {

    private final ConnectionFactory connectionFactory;

    public MySQLProductCategoryDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public ProductCategory create(String name) {

        try (Connection connection = connectionFactory.getConnection()){
            Statement statement = connection.createStatement();
            int rowUpdated = statement.executeUpdate("INSERT INTO productCategory(name) VALUES (\"" + name + "\")");
            System.out.println("Row(s) affected = " + rowUpdated);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM productCategory WHERE name = \"" + name + "\"");
            resultSet.next();
            return new ProductCategory(resultSet.getInt(1), resultSet.getString((2)));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAll() {
        try (Connection connection = connectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from productCategory");
            while (result.next()) {
                System.out.println("ID = " + result.getInt(1));
                System.out.println("Name = " + result.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
