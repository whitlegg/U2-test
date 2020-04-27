<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-11-21
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.js"></script>
</head>
<body>
<center>
    <h1>用户数据列表</h1>
    <form action="${pageContext.request.contextPath}/main?cmd=list" method="post" id="myform">
        <p>
            卡种类分类：
           <%-- //下拉框--%>
            <select name="scardId">
                <option value="">==全部==</option>
              <c:forEach items="${card}" var="card">
                    <option value="${card.cardid}"
                    <c:if test="${card.cardid==some.scardId}">
                        selected
                    </c:if>
                    >${card.cardname}</option>
                </c:forEach>
            </select>
            姓名：
            <input type="text" name="suserName" value="${some.suserName}">
            <input type="submit" value="查询" id="btn">
            <a href="add.jsp">添加账户</a>

        </p>
    <table border="1" cellspacing="0" cellpadding="5" width="60%">
        <tr>
            <th>账号编号</th>
            <th>姓名</th>
            <th>详细地址</th>
            <th>开户时间</th>
            <th>卡种</th>
            <th>删除</th>
            <th>修改</th>
        </tr>

       <%-- 动态tr td--%>

          <c:forEach items="${pb.data}" var="data">
              <tr>
                  <td>${data.usernum}</td>
                  <td>${data.username}</td>
                  <td>${data.useraddr}</td>
                  <td>${data.createdate}</td>
                  <td>${data.cardname}</td>
                  <td><a href="${pageContext.request.contextPath}/main?cmd=del&id=${data.userid}">删除</a></td>
                  <td><a href="${pageContext.request.contextPath}/main?cmd=updataUI&id=${data.userid}">修改</a></td>
              </tr>
          </c:forEach>
    </table>
       <%-- 共有${pb.count}条记录，第${pb.p}页/共${pb.pageTotal}页&nbsp;&nbsp;--%>
        <a href="javascript:topb(1)">首页</a>
        <a href="javascript:topb(${pb.p-1})">上一页</a>
        <a href="javascript:topb(${pb.p+1})">下一页</a>
        <input type="text" id="text" size="6" value="${pb.p}">
        <a href="#" id="btna">Go</a>
        <a href="javascript:topb(${pb.pageTotal})">尾页</a>&nbsp;&nbsp;
        <input type="hidden" value="1" name="p" id="hid">
    </form>
</center>

</body>
<script>
    //换页
    function topb(p) {
        $("#hid").val(p);
        $("#myform").submit();
    }
    $("#btna").click(function () {
        var $txtp = $("#text").val();
        topb($txtp);
    })
</script>
<script>
    <c:if test="${trydel=='ok'}">
    alert("删除成功！");
    </c:if>
    <c:if test="${trydel=='no'}">
    alert("删除失败！");
    </c:if>
    <c:if test="${tryadd=='ok'}">
    alert("添加成功！");
    </c:if>
    <c:if test="${tryadd=='no'}">
    alert("添加失败！");
    </c:if>
    <c:if test="${tryup=='ok'}">
    alert("修改成功！");
    </c:if>
    <c:if test="${tryup=='no'}">
    alert("修改失败！");
    </c:if>
</script>
</html>
