<%@ page import="Bean.MenuBean" %>
<%@ page import="Dao.MenuDao" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2019-3-18
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

    <link href="css/dist/css/flat-ui.css" rel="stylesheet">
    <link href="css/docs/assets/css/demo.css" rel="stylesheet">
    <link href="css/buttons.css" rel="stylesheet">
</head>
<body>



<%
    String idStr = request.getParameter("updateId");
    int id = Integer.valueOf(idStr);

    MenuDao menuDao = new MenuDao();
    MenuBean menuBean = menuDao.findMenuListById(id);

%>
<div class="row clearfix">
    <div class="col-md-4 column">
    </div>
    <div class="col-md-4 column">
        <form action="/Servlet/UpdateMenuServlet/" method="post">
            <h3 class="demo-panel-title">修改菜品</h3>
            <div class="form-group">
                菜号：<input type="text" name="updateMenuId" value="<%=menuBean.getId()%>" placeholder="试题编号"
                       class="form-control" readonly="readonly"
                       required="required"/>
            </div>
            <div class="form-group has-success">
                菜名：<input type="text" name="updateMenuName" value="<%=menuBean.getName()%>"
                       class="form-control "
                       required="required"/>
            </div>
            <div class="form-group has-success">
                单价：<input type="text" name="updateMenuCost" value="<%=menuBean.getCost()%>"
                          class="form-control "
                          required="required"/>
            </div>
            <div class="form-group">
                备注：<input type="text" name="updateMenuRemark" value="<%=menuBean.getExplain()%>"
                       class="form-control" required="required"/>
            </div>
            <div class="form-group has-success">
                <select type="text" name="updateMenuType"
                       class="form-control" required="required">
                    <%System.out.println(menuBean.getType_num());%>
                    <option value="1" <%if(menuBean.getType_num()==1){%>selected="selected"<%}%>>限时特惠</option>
                    <option value="2" <%if(menuBean.getType_num()==2){%>selected="selected"<%}%>>店长推荐</option>
                    <option value="3" <%if(menuBean.getType_num()==3){%>selected="selected"<%}%>>本店特色</option>
                    <option value="4" <%if(menuBean.getType_num()==4){%>selected="selected"<%}%>>主食</option>
                    <option value="5" <%if(menuBean.getType_num()==5){%>selected="selected"<%}%>>甜点</option>
                    <option value="6" <%if(menuBean.getType_num()==6){%>selected="selected"<%}%>>奶茶</option>
                </select>
            </div>



            <h6>
                <button type="submit" class="button button-glow button-rounded button-raised button-primary">Submit
                </button>
                <button type="button" class="button button-glow button-rounded button-raised button-primary"
                        onclick="window.location='/menuManage.jsp'">返回
                </button>
            </h6>

        </form>
    </div>
    <div class="col-md-4 column">
    </div>
</div>
</body>
</html>
