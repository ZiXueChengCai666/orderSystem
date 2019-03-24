package Servlet;

import Dao.OrderDao;
import service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrderDao orderDao = new OrderDao();
        String orderId = request.getParameter("updateId");
        String orderCount = request.getParameter("updateCount");
        orderDao.updateCount(Integer.parseInt(orderId),Integer.parseInt(orderCount));
        System.out.println(orderId);

        ServletContext thisContext = getServletConfig().getServletContext();
        RequestDispatcher myDispatcher;
        myDispatcher = thisContext.getRequestDispatcher("/text.jsp");
        myDispatcher.forward(request, response);//forward
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
