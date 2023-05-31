
<%--
  Created by IntelliJ IDEA.
  User: 王大锤
  Date: 2023/4/18
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>预定界面</title>
</head>
<body>
<!--查询-->
<form action="Booking" method="post">
    <!--出发站-->
    <div>
        <label>
            始发站：
            <input type="radio" name="startStation" value="west">西校区
            <input type="radio" name="startStation" value="east">东校区
            <input type="radio" name="startStation" value="wuhan">武汉校区
        </label>
    </div>
    <!--终点站-->
    <div>
        <label>
            终点站：
            <input type="radio" name="endStation" value="west">西校区
            <input type="radio" name="endStation" value="east">东校区
            <input type="radio" name="endStation" value="wuhan">武汉校区
        </label>
    </div>
    <!--出发时间-->
    <div>
        <label>
            预出发时间：
            <input type="date" name="startTime"/>
        </label>
    </div>
    <input type="submit" value="查询">
</form>
<%--展示车票--%>
<form action="successbookingStart" method="post">
    <table>
        <thead>
        <tr>
            <td>车次</td>
            <td>出发时间</td>
            <td>票价</td>
            <td>剩余票数</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="shuttle" items="${shuttlelist}">

            <tr>
                <td>${shuttle.shuttleID}</td>
                <td>${shuttle.startTime}</td>
                <td>${shuttle.ticketsPrices}</td>
                <td>${shuttle.ticketsNumber}</td>
                <td>
                    <form action="successbookingStart" method="post">
                        <input type="hidden" name="shuttleID" value="${shuttle.shuttleID}">
                        <input type="submit" value="预订">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>

</body>
</html>
