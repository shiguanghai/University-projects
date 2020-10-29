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
        if (path.equals("/user_personal.action")) {//���˿ռ�
            request.getRequestDispatcher("user_personal.jsp").forward(request, response);
        }else if(path.equals("/user_modify_do.action")){//�û������޸�
//            String un = request.getParameter("un");
//            String pw = request.getParameter("password");
//            String tp = request.getParameter("telephone");
//            String adr = request.getParameter("address");
//            if ((pw == null || pw.equals("")) || (tp == null || tp.equals("")) || (adr == null || adr.equals(""))) {
//                response.getWriter().print("�޸�ʧ�ܣ����ݲ���Ϊ�գ�3�������³��ԣ�");
//            } else {
//                DBUtil db = new DBUtil();
//                String sql = "update user set password=?, telephone=?, address=? where username=?";
//                String[] params = {pw, tp, adr, un};
//                int result = db.update(sql, params);
//                if (result == 1) {
//                    response.getWriter().print("�޸ĳɹ���3�����ת��");
//                } else {
//                    response.getWriter().print("�޸�ʧ�ܣ�3�������³��ԣ�");
//                }
//            }
//            response.setHeader("refresh", "3;url=user_home.action");
        }
    }
}
