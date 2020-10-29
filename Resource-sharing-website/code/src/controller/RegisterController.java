package controller;

import service.LoginService;
import service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns ={"/register.action","/register_uname.action","/register_pword.action"})
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        if (path.equals("/register.action")) {//ע����Ϣ�洢
            String un = request.getParameter("username");
            String pw = request.getParameter("password");
            String tp = request.getParameter("telephone");
            String adr = request.getParameter("address");
            String id = "0";
            String[] params = {un, pw, id, tp, adr};
            String ret = "No";
            int result = RegisterService.getRegisterInformation(params);
            if (result == 1) {
                ret = "Yes";
            }
            PrintWriter out = response.getWriter();
            out.write(ret);
            out.flush();
            out.close();
        }else if(path.equals("/register_uname.action")) {//ע��:�û����ж�
            String un = request.getParameter("uname");
            String[] params = {un};
            String ret = "No";
            Map<String, String> result = RegisterService.getRegisterUnameList(params);
            if (result == null) {//���û�δʹ��
                ret = "Yes";
            }
            if (un == null || un.equals("")) {//δ����
                ret = "blank";
            }
            PrintWriter out = response.getWriter();
            out.write(ret);
            out.flush();
            out.close();
        }else if(path.equals("/register_pword.action")) {//ע��:�����ж�
            String pw = request.getParameter("pword");
            String ret = "No";
            if(isLetterDigit(pw)){
                ret = "Yes";
            }
            if (pw == null || pw.equals("")) {//Ϊ����
                ret = "blank";
            }
            PrintWriter out = response.getWriter();
            out.write(ret);
            out.flush();
            out.close();
        }
    }

    /**
     * ������Сд��ĸ����������6-16λ
     * �Ƿ����
     *
     * @param str
     * @return
     */
    public static boolean isLetterDigit(String str) {
        boolean isDigit = false;//����һ��booleanֵ��������ʾ�Ƿ��������
        boolean isLetter = false;//����һ��booleanֵ��������ʾ�Ƿ������ĸ
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {   //��char��װ���е��ж����ֵķ����ж�ÿһ���ַ�
                isDigit = true;
            } else if (Character.isLetter(str.charAt(i))) {  //��char��װ���е��ж���ĸ�ķ����ж�ÿһ���ַ�
                isLetter = true;
            }
        }
        String regex = "^[a-zA-Z0-9]{6,16}$";
        boolean isRight = isDigit && isLetter && str.matches(regex);
        return isRight;
    }
}
