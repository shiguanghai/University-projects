package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns ={"/user_personal.action","/user_modify_do.action"})
public class PersonalController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        if (path.equals("/user_personal.action")) {//个人空间
            request.getRequestDispatcher("user_personal.jsp").forward(request, response);
        }else if(path.equals("/user_modify_do.action")){//用户资料修改
//            String un = request.getParameter("un");
//            String pw = request.getParameter("password");
//            String tp = request.getParameter("telephone");
//            String adr = request.getParameter("address");
//            if ((pw == null || pw.equals("")) || (tp == null || tp.equals("")) || (adr == null || adr.equals(""))) {
//                response.getWriter().print("修改失败，内容不能为空，3秒后可重新尝试！");
//            } else {
//                DBUtil db = new DBUtil();
//                String sql = "update user set password=?, telephone=?, address=? where username=?";
//                String[] params = {pw, tp, adr, un};
//                int result = db.update(sql, params);
//                if (result == 1) {
//                    response.getWriter().print("修改成功，3秒后跳转！");
//                } else {
//                    response.getWriter().print("修改失败，3秒后可重新尝试！");
//                }
//            }
//            response.setHeader("refresh", "3;url=user_home.action");
        }
    }
}
