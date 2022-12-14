package Java_1020;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class AWSConn implements DoConnection{
    @Override
    public Connection conectionMaker() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                env.get("DB_HOST"), env.get("DB_USER"),env.get("DB_PASSWORD")
        );



        return conn;
    }
}
