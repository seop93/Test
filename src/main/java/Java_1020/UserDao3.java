package Java_1020;



import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserDao3 {

    private DoConnection conn;

    public UserDao3() {

    }

    public UserDao3(DoConnection conn) {
        this.conn = conn;
    }

    public void add(User3 user3) throws ClassNotFoundException, SQLException {

        Connection c = conn.conectionMaker();
        PreparedStatement psmt = c.prepareStatement(
                "INSERT INTO users(id,name,password) values(?,?,?);"
        );

        psmt.setString(1, user3.getId());
        psmt.setString(2,user3.getName());
        psmt.setString(3, user3.getPassword());

        int status = psmt.executeUpdate();
        psmt.close();
        c.close();
    }

    public User3 select(String id) throws SQLException, ClassNotFoundException {
        Map<String, String> env = System.getenv();
        Connection c;

        c = conn.conectionMaker();
        PreparedStatement ps = c.prepareStatement("SELECT id,name,password FROM users WHERE id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        User3 user3 = null;
        if(rs.next()) {
            user3 = new User3(rs.getString("id"), rs.getString("name")
                    , rs.getString("password"));
        }
        rs.close();
        ps.close();
        c.close();
        if(user3 == null) throw new EmptyResultDataAccessException(1);
        return user3;

    }

    public void deleteAll() throws ClassNotFoundException, SQLException{
        Connection c = conn.conectionMaker();
        PreparedStatement psmt = c.prepareStatement("delete from users;");
        psmt.executeUpdate();
        psmt.close();
        c.close();

    }

    public int getCount() throws SQLException, ClassNotFoundException{
        Connection c = conn.conectionMaker();
        PreparedStatement psmt = c.prepareStatement("select count(*) from users");
        ResultSet rs = psmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        psmt.close();
        c.close();

        return count;

    }


}
