package Servlet;

import Bean.MenuBean;
import Bean.OrderBean;
import Dao.MenuDao;
import Dao.OrderDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddMenuServlet")
public class AddMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int type = Integer.parseInt(request.getParameter("addType"));

        String name = request.getParameter("addName");
        String remark = request.getParameter("addRemark");
        int cost = Integer.parseInt(request.getParameter("addCost"));
        PrintWriter out = response.getWriter();

        MenuBean menuBean = new MenuBean();
        menuBean.setName(name);
        menuBean.setExplain(remark);
        menuBean.setCost(cost);
        menuBean.setType_num(type);

        new MenuDao().insertMenu(menuBean);

        response.sendRedirect("/menuManage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
