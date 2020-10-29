package controller;

import service.HomeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns ={"/home.action","/user_home.action","/logout.action"})
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        if (path.equals("/home.action")||path.equals("/user_home.action")||path.equals("/logout.action")) {//首页
            List<Map<String, String>> carousel = HomeService.getCarouselList();
            List<Map<String, String>> video = HomeService.getVideoList();
            List<Map<String, String>> film = HomeService.getFilmList();
            List<Map<String, String>> film_left = HomeService.getFilmLeftList();
            request.setAttribute("carousel", carousel);
            request.setAttribute("video", video);
            request.setAttribute("film", film);
            request.setAttribute("film_left", film_left);
            if(path.equals("/home.action")){
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }else if(path.equals("/user_home.action")){//用户登录首页
                request.getRequestDispatcher("user_home.jsp").forward(request, response);
            }else {//账号退出
                request.getSession().removeAttribute("un");
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        }
    }
}
