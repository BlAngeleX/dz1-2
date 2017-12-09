package nonstatic;

import dao.ProductCategory;
import dao.ProductCategoryDao;
import nonstatic.ConnectionFactory;
import nonstatic.MySQLProductCategoryDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Mockito.when;

/**
 * Created by admin on 08.12.2017.
 */
public class MySQLProductCategoryDaoTest {

    @Mock
    private ConnectionFactory connectionFactory;
    @Mock
    private Connection connection;
    @Mock
    private Statement statement;
    @Mock
    private ResultSet resultSet;

    private ProductCategoryDao dao;

    @BeforeEach
    public void setup() throws SQLException {
        MockitoAnnotations.initMocks(this);
        when(connectionFactory.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
        //connectionFactory = Mockito.mock(ConnectionFactory.class);
        dao = new MySQLProductCategoryDao(connectionFactory);
    }

    @Test
    public void testCreate() throws SQLException {
//        String name = "1234";
//        String sql = "INSERT INTO productCategory(name) VALUES (\"" + name + "\")";
//        String select = "SELECT * FROM productCategory WHERE name = \"" + name + "";
//
//        when(statement.executeQuery(select)).thenReturn(resultSet);
//
//        dao.create(name);
//
//        Mockito.verify(statement).executeUpdate(sql);

        int categoryId = 5;
        String name = "games";
        int rowUpdated = 1;
        when(statement.executeUpdate(Matchers.anyString())).thenReturn(rowUpdated);
        when(statement.executeQuery(Matchers.anyString())).thenReturn(resultSet);
        when(resultSet.getInt(1)).thenReturn(categoryId);
        when(resultSet.getString(2)).thenReturn(name);

        ProductCategory category = dao.create(name);
        Assertions.assertEquals(category, category.getCategoryId());
        Assertions.assertEquals(name, category.getName());

    }
}
