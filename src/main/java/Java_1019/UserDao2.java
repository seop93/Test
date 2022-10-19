package Java_1019;

import Java_1018.User1;

import java.sql.*;
import java.util.Map;

public class UserDao2 {

    private ConnectionMaker connectionMaker;

    public UserDao2(){
        connectionMaker = new AWSConnection();
    }

    public UserDao2(ConnectionMaker c) {
        this.connectionMaker = c;

    }

    public void add(User2 user1) throws SQLException, ClassNotFoundException {

        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "INSERT INTO users(id,name,password) values(?,?,?);"
        );
        ps.setString(1, user1.getId());
        ps.setString(2, user1.getName());
        ps.setString(3, user1.getPassword());

        int status = ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User1 select(String id) throws SQLException, ClassNotFoundException {
        Map<String, String> env = System.getenv();
        Connection c;

        c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("SELECT id,name,password FROM users WHERE id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User1 user = new User1(rs.getString("id"), rs.getString("name")
                , rs.getString("password"));
        rs.close();
        ps.close();
        c.close();
        return user;

    }


}


