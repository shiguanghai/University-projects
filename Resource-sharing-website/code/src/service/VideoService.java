package service;

import dao.DBUtil;
import model.Video;
import model.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoService {
    //推荐视频
    public static List getVideoRecommendList(){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql1="select * from video where reco = 1 limit 0,12";
            pstmt=con.prepareStatement(sql1);
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
    //热门视频
    public static List getVideoHotList(){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con= DBUtil.getCon();

            String sql1="select * from video where reco = 0 limit 0,12";
            pstmt=con.prepareStatement(sql1);
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
    //视频专栏 专栏视频
    public static List<Type> getTypeList() {
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection con=null;

        try{
            con=DBUtil.getCon();

            String sql_type="select * from type";
            String sql_video="select * from video where type like ? limit 0,6";

            pstmt=con.prepareStatement(sql_type);
            rs=pstmt.executeQuery();

            List<Type> list=new ArrayList<Type>();

            while(rs.next()){
                Type type=new Type();
                type.setId(rs.getInt("id"));
                type.setTypeName(rs.getString("typename"));
                type.setPicture(rs.getString("picture"));

                //获取专栏视频
                PreparedStatement ps_video = con.prepareStatement(sql_video);
                ps_video.setString(1, "%"+rs.getInt("id")+"%");
                ResultSet rs_video = ps_video.executeQuery();
                List<Video> videolist = new ArrayList<Video>();
                while(rs_video.next()){
                    if(rs_video.getRow()<7){
                        Video video=new Video();
                        video.setId(rs_video.getInt("id"));
                        video.setVideoName(rs_video.getString("video_name"));
                        video.setUrl(rs_video.getString("url"));
                        video.setAddress(rs_video.getString("address"));
                        video.setIframe(rs_video.getString("iframe"));
                        video.setType(rs_video.getString("type"));
                        video.setReco(rs_video.getInt("reco"));
                        videolist.add(video);
                        type.setVideoList(videolist);
                    }
                }

                list.add(type);
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
