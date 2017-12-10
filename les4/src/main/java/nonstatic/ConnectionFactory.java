package nonstatic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 08.12.2017.
 */
public interface ConnectionFactory {

    Connection getConnection () throws SQLException;
}
