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
        //��ʱδ���ҳ������
        if (path.equals("/film_home.action")||path.equals("/user_film_home.action")) {//������Ӱ
            if(path.equals("/film_home.action")){
                request.getRequestDispatcher("film.jsp").forward(request, response);
            }else {//�û���¼������Ӱ
                request.getRequestDispatcher("user_film.jsp").forward(request, response);
            }
        } else if (path.equals("/program_home.action")||path.equals("/user_program_home.action")) {//������
            if(path.equals("/program_home.action")){
                request.getRequestDispatcher("program.jsp").forward(request, response);
            }else {//�û���¼������
                request.getRequestDispatcher("user_program.jsp").forward(request, response);
            }
        } else if (path.equals("/song_home.action")||path.equals("/user_song_home.action")) {//��������
            if(path.equals("/song_home.action")){
                request.getRequestDispatcher("song.jsp").forward(request, response);
            }else {//�û���¼��������
                request.getRequestDispatcher("user_song.jsp").forward(request, response);
            }
        } else if (path.equals("/article_home.action")||path.equals("/user_article_home.action")) {//�����Ƽ�
            if(path.equals("/article_home.action")){
                request.getRequestDispatcher("article.jsp").forward(request, response);
            }else {//�û���¼�����Ƽ�
                request.getRequestDispatcher("user_article.jsp").forward(request, response);
            }
        }
    }
}


