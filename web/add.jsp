<%@ page import="Dao.MenuDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.MenuBean" %>
<%@ page import="Bean.OrderBean" %><%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2019-3-12
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>


</head>
<body>
<%
    String name = "";
    MenuDao menuDao = new MenuDao();
    ArrayList<MenuBean> list;
    MenuBean menuBean;

%>
<%
    String str = request.getParameter("submit_orderAddNum");
    String num = (String)request.getAttribute("num");
    String num1 = request.getParameter("ordernum");
    System.out.println(num);
    System.out.println(num1);
    if(num1 != null){
        str = num1;
    }
    if(num != null){
        str = num;
    }
//
%>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6">
            <table class="table">
                <form action="/add.jsp" class="form-search">
                    <input name="ordernum" value=<%=str%> type="text" hidden="hidden"/>
                    <%=str%>号
                    <input name="orderName" value="" type="text"/>
                    <button type="submit" class="btn">查找</button>
                </form>
                <%
                    if (request.getParameter("orderName") != null) {
                        name = new String(request.getParameter("orderName").getBytes("iso-8859-1"), "utf-8");
                    }
                    list = menuDao.searchByName(name);
                %>
                <%
                    for (int i = 0; i < list.size(); i++) {
                         menuBean = list.get(i);

                %>
                <tr><br>
                    菜号：<%=menuBean.getId()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </tr>
                <tr>
                    菜名：<%=menuBean.getName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </tr>
                <tr>
                    单价：<%=menuBean.getCost()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </tr>


                <form action="/Servlet/AddServlet/" method="post">
                    <input type="text" name="orderAddNum"  value="<%=str%>"  hidden="hidden"/>
                    <input type="text" name="orderAddName"  value="<%=menuBean.getName()%>"  hidden="hidden"/>
                    <input type="text" name="orderAddCost"  value="<%=menuBean.getCost()%>"  hidden="hidden"/>
                    份数：<input type="text" name="orderCount"  value="1"  />

                    <button type="submit"> 添加</button>
                </form>
                <%}%>



            </table>
            <button type="button" class="btn btn-block btn-lg btn-danger" onclick="window.location='/text.jsp'">返回</button>

        </div>
    </div>
</div>
</body>
</html>
