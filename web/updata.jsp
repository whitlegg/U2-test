<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-11-25
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>添加信息</h1>
    <form action="${pageContext.request.contextPath}/main?cmd=updata" method="post">

        <table border="1" cellspacing="0" cellpadding="5" width="50%" style="text-align: center">
            <input type="hidden" name="userid" value="${user.userid}">
            <%--<input type="hidden" name="createdate" value="${user.createdate}">--%>
            <tr>
                <td>账号编号</td>
                <td><input type="text" name="usernum" value="${user.usernum}"></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="username" value="${user.username}"></td>
            </tr>
            <tr>
                <td>详细地址</td>
                <td><input type="text" name="useraddr" value="${user.useraddr}"></td>
            </tr>
            <tr>
                <td>卡种</td>
                <td>
                    <select name="cardsid">
                        <c:forEach items="${card}" var="card">
                            <option value="${card.cardid}"
                                    <c:if test="${card.cardid==user.cardsid}">
                                        selected
                                    </c:if>
                            >${card.cardname}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
