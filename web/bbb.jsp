<%@ page import="service.OrderService" %><%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2019-3-12
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>
<body>

<%
    OrderService orderService = new OrderService();
    String str = request.getParameter("submit_orderNum");
    int money = orderService.payBill(Integer.parseInt(str));
    orderService.deleteOrder(Integer.parseInt(str));
%>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="page-header">
                <h1>
                    <%=str%>号顾客消费：<%=money%>
                </h1>
            </div>

        </div>
    </div>
    <button onclick="window.location='/text.jsp'">
        返回
    </button>
</div>


</body>
</html>
