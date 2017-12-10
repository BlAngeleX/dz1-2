package dao;

import nonstatic.ConnectionFactory;

import java.sql.*;

/**
 * Created by admin on 04.12.2017.
 */
public class MySQLProductCategoryDao implements ProductCategoryDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public ProductCategory create(String name) {
        //Connection connection = null;
        //Statement statement = null;
        try (Connection connection = JdbcUtils.getConnection()){
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            Statement statement = connection.createStatement();
            int rowUpdated = statement.executeUpdate("INSERT INTO productCategory(name) VALUES (\"" + name + "\")");

            if (rowUpdated == 0)
                return null;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM productCategory WHERE name = \"" + name + "\"");
            resultSet.next();
            return new ProductCategory(resultSet.getInt(1), resultSet.getString((2)));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getAll() {
        try (Connection connection = JdbcUtils.getConnection()) {
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
