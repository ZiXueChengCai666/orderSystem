package Servlet;

import service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrderService orderService = new OrderService();
        String orderId = request.getParameter("submit_orderDeleteId");
        orderService.deleteById(Integer.parseInt(orderId));
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
