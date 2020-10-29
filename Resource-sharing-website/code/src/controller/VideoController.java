package controller;

import model.Type;
import net.sf.json.JSONArray;
import service.VideoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns ={"/video_home.action","/user_video_home.action","/video_home_mobile.action"})
public class VideoController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        if (path.equals("/video_home.action")||path.equals("/user_video_home.action")) {//视频创作
            List<Map<String, String>> video_tuijian = VideoService.getVideoRecommendList();
            List<Map<String, String>> video_remen = VideoService.getVideoHotList();
            List<Type> typelist = VideoService.getTypeList();
            request.setAttribute("video_tuijian", video_tuijian);
            request.setAttribute("video_remen", video_remen);
            request.setAttribute("typelist", typelist);
            if(path.equals("/video_home.action")){
                request.getRequestDispatcher("video.jsp").forward(request, response);
            }else {//用户登录视频创作
                request.getRequestDispatcher("user_video.jsp").forward(request, response);
            }

        }else if(path.equals("/video_home_mobile.action")){
            List<Map<String, String>> typelist = VideoService.getVideoRecommendList();
            JSONArray result = JSONArray.fromObject(typelist);
            PrintWriter out = response.getWriter();
            out.print(result);
            out.flush();
        }
    }
}
