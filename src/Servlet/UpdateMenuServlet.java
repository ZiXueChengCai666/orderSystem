package Servlet;

import Bean.MenuBean;
import Dao.MenuDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateMenuServlet")
public class UpdateMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("updateMenuId"));
        String name = request.getParameter("updateMenuName");
        int cost = Integer.parseInt(request.getParameter("updateMenuCost"));
        String remark = request.getParameter("updateMenuRemark");
        int type = Integer.parseInt(request.getParameter("updateMenuType"));

        MenuBean menuBean = new MenuBean();
        menuBean.setId(id);
        menuBean.setCost(cost);
        menuBean.setType_num(type);
        menuBean.setExplain(remark);
        menuBean.setName(name);

        new MenuDao().updateMenu(menuBean);

        response.sendRedirect("/menuManage.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
