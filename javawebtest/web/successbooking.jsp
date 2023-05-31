<%@ page import="java.nio.charset.StandardCharsets" %><%--
  Created by IntelliJ IDEA.
  User: 王大锤
  Date: 2023/4/19
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<head>
    <title>确认预订界面</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
%>
<%-- 根据前一个页面选择的车票信息展示车票的出发时间 --%>
<p>您的用户名是：<%= request.getAttribute("username")%></p>
<p>您的真实姓名是：<%= request.getAttribute("truename") %></p>
<p>您所选择的车票的车次是：<%= request.getAttribute("shuttleID") %></p>
<p>您所选择的车票的出发时间是：<%= request.getAttribute("startTime") %></p>
<p>您所选择的车票的始发站是：<%= request.getAttribute("startStation")%></p>
<p>您所选择的车票的始发站是：<%= request.getAttribute("endStation")%></p>
<%-- 提供确认购票和取消操作 --%>
<form action="ConfirmBooking" method="post">
    <input type="hidden" name="shuttleID" value="<%= request.getParameter("shuttleID") %>"><%-- value="<%= request.getParameter("shuttleID") %>">--%>
    <input type="submit" value="确定购票">
</form>

<a href="bookingtickets.jsp"><button>取消</button><br></a><br>
</body>
</html>
