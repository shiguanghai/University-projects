package service;

import dao.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeService {
    //ÂÖ²¥Í¼ÊÓÆµÍÆ¼ö
    public static List getCarouselList(){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql1="select * from carousel limit 0,3";
            pstmt=con.prepareStatement(sql1);
            rs=pstmt.executeQuery();
            List<Map<String,String>> list=new ArrayList<Map<String,String>>();
            while(rs.next()){

                Map map=new HashMap();
                map.put("id", rs.getString("id"));
                map.put("carousel",rs.getString("carousel"));
                map.put("url", rs.getString("url"));
                map.put("address", rs.getString("address"));
                map.put("iframe", rs.getString("iframe"));
                list.add(map);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            DBUtil.close(rs,pstmt,con);
        }
    }
    //Ê×Ò³ÊÓÆµÍÆ¼ö
    public static List getVideoList(){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql="select * from video limit 0,6";
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            List<Map<String,String>> list=new ArrayList<Map<String,String>>();
            while(rs.next()){

                Map map=new HashMap();
                map.put("id", rs.getString("id"));
                map.put("video_name",rs.getString("video_name"));
                map.put("url", rs.getString("url"));
                map.put("address", rs.getString("address"));
                map.put("iframe", rs.getString("iframe"));
                map.put("type", rs.getString("type"));
                map.put("reco", rs.getString("reco"));
                list.add(map);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            DBUtil.close(rs,pstmt,con);
        }
    }
    //Ê×Ò³ÉãÓ°Í¼Æ¬ÍÆ¼ö
    public static List getFilmList(){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql="select * from film where flag ='home' limit 0,7";
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            List<Map<String,String>> list=new ArrayList<Map<String,String>>();
            while(rs.next()){

                Map map=new HashMap();
                map.put("id", rs.getString("id"));
                map.put("film_author",rs.getString("film_author"));
                map.put("url", rs.getString("url"));
                map.put("address", rs.getString("address"));
                map.put("flag", rs.getString("flag"));
                list.add(map);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            DBUtil.close(rs,pstmt,con);
        }
    }
    public static List getFilmLeftList(){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql="select * from film where flag ='home_left' limit 0,2";
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            List<Map<String,String>> list=new ArrayList<Map<String,String>>();
            while(rs.next()){

                Map map=new HashMap();
                map.put("id", rs.getString("id"));
                map.put("film_author",rs.getString("film_author"));
                map.put("url", rs.getString("url"));
                map.put("address", rs.getString("address"));
                map.put("flag", rs.getString("flag"));
                list.add(map);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            DBUtil.close(rs,pstmt,con);
        }
    }
}
