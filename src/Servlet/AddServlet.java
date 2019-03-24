package Servlet;

import Bean.OrderBean;
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

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int number = Integer.parseInt(request.getParameter("orderAddNum"));

        System.out.println(number);
        String name = request.getParameter("orderAddName");
        int count = Integer.parseInt(request.getParameter("orderCount"));
        int cost = Integer.parseInt(request.getParameter("orderAddCost"));
        PrintWriter out = response.getWriter();

        OrderBean orderBean = new OrderBean();
        orderBean.setName(name);
        orderBean.setCount(count);
        orderBean.setPrice(cost);

        new OrderDao().insertOrder(orderBean,number);
        request.setAttribute("num",number+"");

        ServletContext thisContext = getServletConfig().getServletContext();
        RequestDispatcher myDispatcher;
        myDispatcher = thisContext.getRequestDispatcher("/add.jsp");
        myDispatcher.forward(request, response);//forward


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
