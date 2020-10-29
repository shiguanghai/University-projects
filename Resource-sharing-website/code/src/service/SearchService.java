package service;

import dao.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchService {
    //����-�����˵���ʾ��
    public static List getSearchSubmitList(String keyword){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql1="select * from video where video_name like ? limit 0,8";
            pstmt=con.prepareStatement(sql1);
            pstmt.setString(1,"%"+keyword+"%");
            rs=pstmt.executeQuery();
            List<Map<String,String>> list=new ArrayList<Map<String,String>>();
            while(rs.next()){

                Map map=new HashMap();
                map.put("id", rs.getString("id"));
                map.put("video_name",rs.getString("video_name"));
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
    //����-����idת��Ϊ����������
    public static List getSearchTitle(int id){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql1="select * from video where id =?";
            pstmt=con.prepareStatement(sql1);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            List<Map<String,String>> list=new ArrayList<Map<String,String>>();
            while(rs.next()){

                Map map=new HashMap();
                map.put("video_name",rs.getString("video_name"));
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
    //����-����ͨ�������˵���ת��ȡ���������
    public static List getSearchList(int id){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql1="select * from video where id =?";
            pstmt=con.prepareStatement(sql1);
            pstmt.setInt(1,id);
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
    //����-���������ť
    public static List getSearchSubmitKeywordList(String keyword){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql1="select * from video where video_name like ?";
            pstmt=con.prepareStatement(sql1);
            pstmt.setString(1,"%"+keyword+"%");
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
    //����-���������������ǩ
    public static List getSearchSubmitUpdateList(String keyword,String type){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql1="select * from video where video_name like ? and type like ?";
            pstmt=con.prepareStatement(sql1);
            pstmt.setString(1,"%"+keyword+"%");
            pstmt.setString(2,"%"+type+"%");
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
}
