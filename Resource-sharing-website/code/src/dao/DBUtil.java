package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
    //连接数据库
    public static Connection getCon(){
        Connection con=null;
        String url = "jdbc:mysql://localhost:3306/javaweb?characterEncoding=gbk&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "Wzb991216";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    //关闭数据库
    public static void close(ResultSet rs, PreparedStatement ps, Connection con){
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
