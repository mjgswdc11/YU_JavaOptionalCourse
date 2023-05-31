package demo1.servlet;

import demo1.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet( "/successbookingStart")
public class successbookingStartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer shuttleID= Integer.parseInt(request.getParameter("shuttleID"));
        String userName=LoginServlet.username;
        String trueName= DBUtil.takeUserTrueName(userName);
        String startTime=DBUtil.takeStartTimeByShuttleID(shuttleID);
        String startStation=DBUtil.takeStartStationByShuttleID(shuttleID);
        String endStation=DBUtil.takeEndStationByShuttleID(shuttleID);

        request.setAttribute("username",userName);
        request.setAttribute("truename",trueName);
        request.setAttribute("shuttleID",shuttleID);
        request.setAttribute("startTime",startTime);
        request.setAttribute("startStation",startStation);
        request.setAttribute("endStation",endStation);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/successbooking.jsp");
        dispatcher.forward(request, response);

    }
}
