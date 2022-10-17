import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class UserDao  {
    public void add() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
        "jdbc:mysql://ec2-13-124-214-17.ap-northeast-2.compute.amazonaws.com:3306/likelion-db", "root", "password"
        );
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(id,name,password) values(?,?,?)"
        );
        ps.setString(1,"0");
        ps.setString(2,"heungseop");
        ps.setString(3, "1123");

        int status = ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        UserDao userdao = new UserDao();
        userdao.add();
    }


}
