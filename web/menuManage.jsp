<%@ page import="Dao.MenuDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.MenuBean" %><%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2019-3-18
  Time: 8:49
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
    MenuDao menuDao = new MenuDao();
    ArrayList<MenuBean> arrayList;
    MenuBean menuBean;
    String name = "";

%>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <br>
            <h2 class="text-center text-success">
                菜单管理
            </h2>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-8 column">

            <form class="form-horizontal" role="form" action="/menuManage.jsp">

                <div class="form-group">

                    <div class="col-sm-10">
                        <p>菜品查找:<br>
                            <input type="text" name="selectMenu" placeholder="直接提交显示全部菜品" class="form-control"
                                   id="inputEmail3"/>
                            <span class="input-icon fui-check-inverted"></span>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="button button-action button-pill">submit</button>
                    </div>
                </div>
            </form>
            <%
                if (request.getParameter("selectMenu") != null) {
                    name = new String(request.getParameter("selectMenu").getBytes("iso-8859-1"), "utf-8");
                }
                arrayList = menuDao.findMenuList(name);%>

            <% for (int i = 0; i < arrayList.size(); i++) {
                menuBean = arrayList.get(i);
            %>
            <table class="table">
                <tbody>
                <tr class="success">
                    <td>
                        菜品编号：<%out.print(menuBean.getId());%>
                        <br>
                        菜名：<%out.print(menuBean.getName());%><%for (int j = 0; j < 7; ++j)%>&nbsp;

                        单价：<%out.print(menuBean.getCost());%><%for (int j = 0; j < 7; ++j)%>&nbsp;

                        备注：<%out.print(menuBean.getExplain());%>
                        <br>
                        类别：<%out.print(menuBean.getType());%>

                    </td>
                </tr>

                </tbody>
            </table>
            <%}%>

        </div>
        <div class="col-md-4 column">
            <form action="/Servlet/AddMenuServlet/" method="post">
                <br><br>
                <p>添加菜品:<br>

                    <input type="text" name="addName" value="" placeholder="菜名" class="form-control "
                           required="required"/>
                    <span class="input-icon fui-check-inverted"></span>
                    <input type="text" name="addCost" value="" placeholder="单价" class="form-control"
                           required="required"/>
                    <span class="input-icon fui-check-inverted"></span>

                    <select type="text" name="addType" value="" placeholder="类别" class="form-control"
                           required="required">
                        <option value="1">限时特惠</option>
                        <option value="2">店长推荐</option>
                        <option value="3">本店特色</option>
                        <option value="4">主食</option>
                        <option value="5">甜点</option>
                        <option value="6">奶茶</option>
                    </select>
                    <span class="input-icon fui-check-inverted"></span>
                    <input type="text" name="addRemark" value="" placeholder="备注" class="form-control"
                           required="required"/>
                    <span class="input-icon fui-check-inverted"></span>


                    <button type="submit" class="button button-glow button-rounded button-raised button-primary">
                        Submit
                    </button>

            </form>

            <form action="/Servlet/DeleteMenuServlet/" method="post">
                <br>
                <p>删除菜品<br>

                    <input type="text" name="deleteMenuId" placeholder="菜号" class="form-control" required="required"
                           onKeyUp="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')"/>
                <h6>
                    <button type="submit" class="button button-glow button-rounded button-highlight">Submit</button>
                </h6>
            </form>

            <form action="/updateMenu.jsp" method="post">
                <br>
                <p>修改菜品<br>
                    <input type="text" name="updateId" value="" placeholder="输入菜号" class="form-control "
                           onKeyUp="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')"
                           required="required"/>
                    <span class="input-icon fui-check-inverted"></span>
                <h6>
                    <button type="submit" class="button button-glow button-rounded button-royal">Submit</button>
                </h6>
            </form>

        </div>
    </div>
    <br><br>
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <button type="button" class="btn btn-default btn-info btn-block btn-danger"
                    onclick="window.location='/text.jsp'">返回
            </button>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>



</div>


</body>
</html>
