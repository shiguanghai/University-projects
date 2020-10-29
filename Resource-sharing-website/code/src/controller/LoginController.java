package controller;

import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns ={"/login.action"})
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        if (path.equals("/login.action")) {//登录
            String un = request.getParameter("username");
            String pw = request.getParameter("password");
            String[] params = {un, pw};
            String ret = "No";
            Map<String, String> result = LoginService.getLoginInformationList(params);
            if (result == null) {
                ret = "No";
            } else {
                String ident = result.get("ident");
                request.getSession().setAttribute("un", result.get("username"));
                if (ident.equals("1")) {//管理员
                    ret = "admin";
                } else {//用户
                    ret = "user";
                }
            }
            PrintWriter out = response.getWriter();
            out.write(ret);
            out.flush();
            out.close();
        }
    }
}
