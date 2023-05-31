package demo1.servlet;

import demo1.util.DBUtil;


import javax.servlet.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    public static String username;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求的字符集
        request.setCharacterEncoding("utf-8");
        //设置相应的文本类型
        response.setContentType("text/html;charset=utf-8");
        username=request.getParameter("username");
        String password=request.getParameter("password");
        if(DBUtil.userLoginCheck(username,password))

            response.sendRedirect("bookingtickets.jsp");
        else
            response.sendRedirect("login.html");
    }
}
