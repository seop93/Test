package Java_1020;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDao3Factory {
    @Bean
    public UserDao3 awsDao() {

        UserDao3 userDao3 = new UserDao3(new AWSConn());

        return userDao3;
    }

}
