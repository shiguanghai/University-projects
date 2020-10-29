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
        if (path.equals("/register.action")) {//注册信息存储
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
        }else if(path.equals("/register_uname.action")) {//注册:用户名判定
            String un = request.getParameter("uname");
            String[] params = {un};
            String ret = "No";
            Map<String, String> result = RegisterService.getRegisterUnameList(params);
            if (result == null) {//此用户未使用
                ret = "Yes";
            }
            if (un == null || un.equals("")) {//未输入
                ret = "blank";
            }
            PrintWriter out = response.getWriter();
            out.write(ret);
            out.flush();
            out.close();
        }else if(path.equals("/register_pword.action")) {//注册:密码判定
            String pw = request.getParameter("pword");
            String ret = "No";
            if(isLetterDigit(pw)){
                ret = "Yes";
            }
            if (pw == null || pw.equals("")) {//为输入
                ret = "blank";
            }
            PrintWriter out = response.getWriter();
            out.write(ret);
            out.flush();
            out.close();
        }
    }

    /**
     * 包含大小写字母及数字且在6-16位
     * 是否包含
     *
     * @param str
     * @return
     */
    public static boolean isLetterDigit(String str) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        boolean isLetter = false;//定义一个boolean值，用来表示是否包含字母
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {   //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;
            } else if (Character.isLetter(str.charAt(i))) {  //用char包装类中的判断字母的方法判断每一个字符
                isLetter = true;
            }
        }
        String regex = "^[a-zA-Z0-9]{6,16}$";
        boolean isRight = isDigit && isLetter && str.matches(regex);
        return isRight;
    }
}
