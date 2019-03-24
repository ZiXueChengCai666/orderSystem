package Servlet;

import Bean.JsonResultMenuBean;
import Bean.MenuBean;
import Dao.MenuDao;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class JsonServletMenu extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        JsonResultMenuBean jsonResultBean = new JsonResultMenuBean();
        MenuDao menu = new MenuDao();
        Gson gson = new Gson();
        ArrayList<MenuBean> mlist = menu.findMenuListByType(Integer.parseInt(type));

        jsonResultBean.setMenuData(mlist);
        jsonResultBean.setResult(1);
        out.println(gson.toJson(jsonResultBean));
        System.out.println(gson.toJson(jsonResultBean));





    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
