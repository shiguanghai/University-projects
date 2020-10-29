package service;

import dao.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginService {
    //用户登录信息
    public static Map<String, String> getLoginInformationList(String[] params){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql1="select * from user where username=? and password=?";
            pstmt=con.prepareStatement(sql1);
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    try {
                        pstmt.setString(i+1, params[i]);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            rs=pstmt.executeQuery();
            List<Map<String,String>> list=new ArrayList<Map<String,String>>();

            while(rs.next()){

                Map map=new HashMap();
                map.put("id", rs.getString("id"));
                map.put("username",rs.getString("username"));
                map.put("password", rs.getString("password"));
                map.put("ident", rs.getString("ident"));
                list.add(map);
            }
            Map<String,String> m = null;
            if(list.isEmpty() || list== null || list.size() ==0) {
                return m;
            }else {
                m = (Map<String,String>) (list.get(0));
            }
            return m;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            DBUtil.close(rs,pstmt,con);
        }
    }
}
