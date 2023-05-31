package demo1.servlet;

import demo1.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet( "/ConfirmBooking")
public class ConfirmBookingServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer shuttleID= Integer.parseInt(request.getParameter("shuttleID"));
        DBUtil.ticketsNumberCut(shuttleID);

        response.sendRedirect("success.html");
    }
}
