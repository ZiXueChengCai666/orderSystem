<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.OrderBean" %>
<%@ page import="static until.JsonExplain.parseJson" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="Dao.OrderDao" %>
<%@ page import="com.sun.java.swing.plaf.windows.resources.windows" %><%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2019-3-11
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Text</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">


</head>
<body>
<%
    OrderDao orderDao = new OrderDao();
    ArrayList<Integer> list = orderDao.searchOrderNum();
    ArrayList<OrderBean> orderlist;
    OrderBean orderBean;


%>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
        </div>
        <div class="span6">
            <div class="page-header">
                <h1>
                    餐饮管理系统
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                    <button type="button" class="btn btn-block btn-lg btn-danger" onclick="window.location='/menuManage.jsp'">菜单管理</button>
                </h1>


            </div>
        </div>

        <div class="span3">
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <div id="tablewidget" class="block-body collapse in">

                <table class="table">
                    <%
                        for (int i = 0; i < list.size(); i++) {
                            int num = list.get(i);
                            orderlist = orderDao.SearchOrderList(num);
                    %>
                    <thead>
                    <tr>
                        <th>
                            订单号：<%=num%>&nbsp;
                        </th>
                        <th>
                            <form action="/add.jsp" method="post">
                                <input type="text" name="submit_orderAddNum"  value="<%=num%>" hidden="hidden"/>
                                <button type="submit"> 加菜</button>
                            </form>
                        </th>
                        <th>
                            <form action="/bbb.jsp" method="post">
                                <input type="text" name="submit_orderNum"  value="<%=num%>" hidden="hidden"/>
                                <button type="submit"> 结账</button>
                            </form>


                        </th>

                    </tr>
                    </thead>

                    <tbody>
                    <%
                        for (int j = 0; j < orderlist.size(); j++) {
                            orderBean = orderlist.get(j);
                    %>
                    <tr>
                        <td>
                            菜名：<%=orderBean.getName()%>&nbsp;
                        </td>
                        <td>
                            数量： <%=orderBean.getCount()%> &nbsp;
                        </td>
                        <td>
                            单价：<%=orderBean.getPrice()%> &nbsp;
                        </td>

                        <td>
                            <form action="/Servlet/UpdateServlet/" method="post">
                                <input type="text" name="updateId"  value="<%=orderBean.getId()%>" hidden="hidden"/>
                                <input type="text" name="updateCount"  value="1" />
                                <button type="submit"> 修改</button>
                            </form>
                        </td>
                        <td>
                            <form action="/Servlet/DeleteServlet/" method="post">
                                <input type="text" name="submit_orderDeleteId"  value="<%=orderBean.getId()%>" hidden="hidden"/>
                                <button type="submit"> 删除</button>
                            </form>
                        </td>
                    </tr>

                    <%}%>
                    </tbody>
                    <%}%>

                </table>


            </div>
        </div>
    </div>

    <%--<script>setTimeout("location.href='/text.jsp'",25000)</script>--%>
</body>
</html>
