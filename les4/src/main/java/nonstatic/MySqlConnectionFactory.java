package nonstatic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 08.12.2017.
 */
public class MySqlConnectionFactory implements ConnectionFactory {
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection () throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
    }
}
