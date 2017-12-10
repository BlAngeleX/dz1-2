package nonstatic;

import domain.ProductCategory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
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

    private MySQLProductCategoryDao dao;

    @Before
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


        dao.ProductCategory category = dao.create(name);
        assertEquals(categoryId, category.getCategoryId());
        assertEquals(name, category.getName());

    }
}
