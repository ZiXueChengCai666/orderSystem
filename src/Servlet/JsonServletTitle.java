package Servlet;

import Bean.JsonResultMenuBean;
import Bean.JsonResultTitleBean;
import Bean.MenuBean;
import Bean.TitleBean;
import Dao.MenuDao;
import Dao.TitleDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "JsonServletTitle")
public class JsonServletTitle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JsonResultTitleBean jsonResultBean = new JsonResultTitleBean();
        TitleDao menu = new TitleDao();
        Gson gson = new Gson();
        ArrayList<TitleBean> mlist = menu.findTitleList();

        jsonResultBean.setMlist(mlist);
        jsonResultBean.setResult(1);
        out.println(gson.toJson(jsonResultBean));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
