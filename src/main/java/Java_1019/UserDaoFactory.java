package Java_1019;

public class UserDaoFactory {
    public UserDao2 awsUserDao() {


        AWSConnection awsConnection = new AWSConnection();
        UserDao2 userDao = new UserDao2(awsConnection);
        return userDao;
    }

    public UserDao2 localUserDao(){
        UserDao2 userDao = new UserDao2();
        return userDao;
    }
}
