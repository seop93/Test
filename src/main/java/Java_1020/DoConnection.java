package Java_1020;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DoConnection {
    public Connection conectionMaker() throws ClassNotFoundException, SQLException;
}
