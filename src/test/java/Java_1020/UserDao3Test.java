package Java_1020;

import Java_1019.UserDaoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDao3Factory.class)

class UserDao3Test {
    @Autowired
    ApplicationContext context;

    UserDao3 userDao3;

    @BeforeEach
    void setUp(){
        userDao3 = context.getBean("awsDao", UserDao3.class);
    }


    @Test
    void addAndGet() throws SQLException,ClassNotFoundException{

        //UserDao3 userDao3 = context.getBean("awsDao", UserDao3.class);
        userDao3.deleteAll();
        assertEquals(0,userDao3.getCount());
        String id = "29";
        userDao3.add(new User3(id, "ENEN", "2332"));
        assertEquals(1,userDao3.getCount());
        User3 user3 = userDao3.select(id);

        assertEquals("ENEN", user3.getName());
    }

    @Test
    void count() throws SQLException, ClassNotFoundException{

        User3 user1 = new User3("31", "gil","233");
        User3 user2 = new User3("32","dong","333");
        User3 user3 = new User3("33", "seop", "3422");

        //UserDao3 userDao3 = context.getBean("awsDao", UserDao3.class);
        userDao3.deleteAll();
        assertEquals(0,userDao3.getCount());

        userDao3.add(user1);
        assertEquals(1,userDao3.getCount());
        userDao3.add(user2);
        assertEquals(2, userDao3.getCount());




    }
    @Test
    void findById() throws SQLException,ClassNotFoundException{
        assertThrows(EmptyResultDataAccessException.class, ()->{
            userDao3.select("20");
        });
    }




}