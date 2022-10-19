package Java_1018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void addAndSelect() throws SQLException,ClassNotFoundException {
        UserDao userDao = new UserDao();
        String id = "15";
        userDao.add(new User1(id,"Range","2323"));
        User1 user1 = userDao.select(id);
        Assertions.assertEquals("Range",user1.getName());
    }
}