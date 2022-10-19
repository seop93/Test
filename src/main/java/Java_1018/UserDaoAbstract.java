package Java_1018;

import Java_1017.dbexercise.User;

import java.sql.*;
import java.util.Map;

public class UserDao {
    public void add(User1 user1) throws SQLException, ClassNotFoundException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(id,name,password) values(?,?,?);"
        );
        ps.setString(1,user1.getId());
        ps.setString(2,user1.getName());
        ps.setString(3,user1.getPassword());

        int status = ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public User1 select(String id) throws SQLException{
        Map<String, String> env = System.getenv();

        Connection conn = DriverManager.getConnection(
                env.get("DB_HOST"),env.get("DB_USER"),env.get("DB_PASSWORD")
        );
        PreparedStatement ps = conn.prepareStatement("SELECT id,name,password FROM users WHERE id = ?");
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User1 user = new User1(rs.getString("id"), rs.getString("name")
                ,rs.getString("password"));
        rs.close();
        ps.close();
        conn.close();
        return user;

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        UserDao userDao = new UserDao();
        userDao.add(new User1("7","ruru","12313"));
    }


}
