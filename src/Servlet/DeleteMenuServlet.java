package Servlet;

import Dao.MenuDao;
import service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteMenuServlet")
public class DeleteMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MenuDao menuDao = new MenuDao();
        String menuId = request.getParameter("deleteMenuId");
        menuDao.deleteMenu(Integer.parseInt(menuId));

//

        response.sendRedirect("/menuManage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
