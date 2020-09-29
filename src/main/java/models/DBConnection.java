package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;

    public Connection getConnection() throws SQLException {
        Connection result;
        String username = "postgres";
        String password = "969";
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        if(connection != null){
            result = connection;
        } else {
            result = DriverManager.getConnection(url,username,password);
        }
        return result;

    }
}
