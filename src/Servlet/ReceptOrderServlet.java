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
import java.util.ArrayList;

import static until.JsonExplain.parseJson;


@WebServlet(name = "ReceptOrderServlet")
public class ReceptOrderServlet extends HttpServlet {

    OrderDao orderDao = new OrderDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String json = request.getParameter("json");

        if (json != null && !"".equals(json)) {
            ArrayList<OrderBean> list = parseJson(json);
            orderDao.insertOrderNum();
            int num = orderDao.searchADDNum();
            for (int i = 0; i < list.size(); i++) {
                OrderBean orderBean = list.get(i);
                orderDao.insertOrder(orderBean,num);
                System.out.println("id:" + orderBean.getId() + "  name:" + orderBean.getName() + "  count:" + orderBean.getCount() + "  Price:" + orderBean.getPrice() + "  remark:" + orderBean.getRemark());
            }
            out.println(num);

//            ServletContext thisContext = getServletConfig().getServletContext();
//            RequestDispatcher myDispatcher;
//            myDispatcher = thisContext.getRequestDispatcher("/aaa.jsp");
//            myDispatcher.forward(request, response);//forward



        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


}
