package controller;

import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns ={"/search_submit.action","/search_suggest_keyword.action","/user_search_suggest_keyword.action","/search_suggest.action","/user_search_suggest.action","/search_type_update.action"})
public class SearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        if (path.equals("/search_submit.action")) {
            String keyword = request.getParameter("keyword");
            List<Map<String, String>> search = SearchService.getSearchSubmitList(keyword);
            JSONArray result = JSONArray.fromObject(search);
            PrintWriter out = response.getWriter();
            out.write(String.valueOf(result));
            out.flush();
            out.close();
        } else if(path.equals("/search_suggest_keyword.action")||path.equals("/user_search_suggest_keyword.action")){
            String keyword = request.getParameter("keyword");
            List<Map<String, String>> search_result = SearchService.getSearchSubmitKeywordList(keyword);
            request.setAttribute("search_result", search_result);
            request.getSession().setAttribute("search_title",keyword);
            if(path.equals("/search_suggest_keyword.action")){//游客搜索
                request.getRequestDispatcher("search_suggest.jsp").forward(request, response);
            }else {//用户搜索
                request.getRequestDispatcher("user_search_suggest.jsp").forward(request, response);
            }
        } else if(path.equals("/search_suggest.action")||path.equals("/user_search_suggest.action")){
            int video_id = Integer.parseInt(request.getParameter("id"));//搜索的视频id
            List<Map<String, String>> result_title = SearchService.getSearchTitle(video_id);
            List<Map<String, String>> search_result = SearchService.getSearchList(video_id);
            String title = result_title.get(0).values().toString();
            request.getSession().setAttribute("search_title", StringUtils.strip(title,"[]"));
            request.setAttribute("search_result", search_result);
            if(path.equals("/search_suggest.action")){//游客搜索
                request.getRequestDispatcher("search_suggest.jsp").forward(request, response);
            }else {//用户搜索
                request.getRequestDispatcher("user_search_suggest.jsp").forward(request, response);
            }
        } else if (path.equals("/search_type_update.action")){
            String keyword = request.getParameter("keyword");//关键字
            String type = request.getParameter("type");//标签
            List<Map<String, String>> search_result = SearchService.getSearchSubmitUpdateList(keyword,type);
            JSONArray result = JSONArray.fromObject(search_result);
            PrintWriter out = response.getWriter();
            out.write(String.valueOf(result));
            out.flush();
            out.close();
        }
    }
}
