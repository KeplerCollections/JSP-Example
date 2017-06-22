package bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    public static boolean insert(User bean) {
        boolean status = false;
        try {
            Connection con = ConnectionProvider.getCon();

//	PreparedStatement ps=con.prepareStatement(  
//	    "select * from user432 where email=? and pass=?");  
//	  
//	ps.setString(1,bean.getEmail());  
//	ps.setString(2, bean.getPass());  
            PreparedStatement ps = con.prepareStatement(
                    "insert into user (name,email,password) values (?,?,?)");
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getEmail());
            ps.setString(3, bean.getPass());
            status = ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }

    public static List<User> fetch() {
        List<User> list = new ArrayList<>();
        User user = null;
        try {
            Connection con = ConnectionProvider.getCon();

//	PreparedStatement ps=con.prepareStatement(  
//	    "select * from user432 where email=? and pass=?");  
//	  
//	ps.setString(1,bean.getEmail());  
//	ps.setString(2, bean.getPass());  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPass(rs.getString(4));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return list;
    }

    public static boolean delete(int id) {
        boolean status = false;
        try {
            Connection con = ConnectionProvider.getCon();

//	PreparedStatement ps=con.prepareStatement(  
//	    "select * from user432 where email=? and pass=?");  
//	  
//	ps.setString(1,bean.getEmail());  
//	ps.setString(2, bean.getPass());  
            PreparedStatement ps = con.prepareStatement(
                    "delete from user where id=?");
            ps.setInt(1, id);
            status = ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }
}
