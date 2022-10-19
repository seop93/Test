package Java_1019;

import Java_1018.SqlConnector;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDao2Test {
    @Test
    void addAndSelect() throws SQLException,ClassNotFoundException {
        UserDao2 userDao2 = new UserDaoFactory().awsUserDao();
        String id = "21";
        userDao2.add(new User2(id,"nunu","1212"));
    }

}