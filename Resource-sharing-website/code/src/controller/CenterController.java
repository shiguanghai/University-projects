package controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "*.action",urlPatterns = "*.action")
public class CenterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        //暂时未完成页面内容
        if (path.equals("/film_home.action")||path.equals("/user_film_home.action")) {//个人摄影
            if(path.equals("/film_home.action")){
                request.getRequestDispatcher("film.jsp").forward(request, response);
            }else {//用户登录个人摄影
                request.getRequestDispatcher("user_film.jsp").forward(request, response);
            }
        } else if (path.equals("/program_home.action")||path.equals("/user_program_home.action")) {//程序交流
            if(path.equals("/program_home.action")){
                request.getRequestDispatcher("program.jsp").forward(request, response);
            }else {//用户登录程序交流
                request.getRequestDispatcher("user_program.jsp").forward(request, response);
            }
        } else if (path.equals("/song_home.action")||path.equals("/user_song_home.action")) {//歌曲分享
            if(path.equals("/song_home.action")){
                request.getRequestDispatcher("song.jsp").forward(request, response);
            }else {//用户登录歌曲分享
                request.getRequestDispatcher("user_song.jsp").forward(request, response);
            }
        } else if (path.equals("/article_home.action")||path.equals("/user_article_home.action")) {//好文推荐
            if(path.equals("/article_home.action")){
                request.getRequestDispatcher("article.jsp").forward(request, response);
            }else {//用户登录好文推荐
                request.getRequestDispatcher("user_article.jsp").forward(request, response);
            }
        }
    }
}


