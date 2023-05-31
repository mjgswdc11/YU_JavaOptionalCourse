package demo1.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import demo1.entity.Shuttle;
import demo1.util.DBUtil;

@WebServlet( "/Booking")
public class BookingServlet extends HttpServlet {

    public static String startTimeTemp;
    public static String startStationTemp;
    public static String endStationTemp;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        startStationTemp=request.getParameter("startStation");
        endStationTemp=request.getParameter("endStation");
        startTimeTemp=request.getParameter("startTime");

        switch (startStationTemp)
        {
            case "west":
                startStationTemp="西校区";
                break;
            case "east":
                startStationTemp="东校区";
                break;
            case "wuhan":
                startStationTemp="武汉校区";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + startStationTemp);
        }
        switch (endStationTemp)
        {
            case "west":
                endStationTemp="西校区";
                break;
            case "east":
                endStationTemp="东校区";
                break;
            case "wuhan":
                endStationTemp="武汉校区";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + endStationTemp);
        }
        List <Shuttle>list= DBUtil.shuttlesCheck(startTimeTemp,startStationTemp,endStationTemp);
        request.setAttribute("shuttlelist",list);
        request.getRequestDispatcher("/bookingtickets.jsp").forward(request,response);
    }

}
