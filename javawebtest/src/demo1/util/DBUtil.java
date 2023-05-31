package demo1.util;

import demo1.entity.Shuttle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    public static  boolean userLoginCheck(String userName,String passWord)//通过用户名以及密码来查询是否存在该用户
    {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","123456");
            PreparedStatement statement = connection.prepareStatement("select * from user ");

            ResultSet rs=statement.executeQuery();
            while (rs.next())
            if(userName.equals(rs.getString(2))&&passWord.equals(rs.getString(4)))
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static List<Shuttle> shuttlesCheck(String startTime,String startStation,String endStation)//通过出发时间、始发站、终点站查询班车信息
    {
        List<Shuttle> list=new ArrayList<Shuttle>();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","123456");

            PreparedStatement statement = connection.prepareStatement("select *from shuttle");
            ResultSet rs=statement.executeQuery();

            while (rs.next()) {
                if(startTime.equals(StringUtil.dateToString(rs.getDate(2)))&&startStation.equals(rs.getString(5))&&endStation.equals(rs.getString(6)))
                {
                    Shuttle shuttle=new Shuttle();
                    shuttle.setShuttleID(rs.getInt(1));
                    shuttle.setStartTime(rs.getString(2));
                    shuttle.setTicketsPrices(rs.getFloat(3));
                    shuttle.setTicketsNumber(rs.getInt(4));
                    shuttle.setStartStation(rs.getString(5));
                    shuttle.setEndStation(rs.getString(6));
                    list.add(shuttle);
                }
            }
            //System.out.println(list.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static List<Shuttle>ticketsNumberCut(Integer ShuttleID)//通过传入车票id使对应的车票数-1
    {
        List<Shuttle>list=new ArrayList<Shuttle>();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","123456");

            PreparedStatement statement = connection.prepareStatement("update shuttle set ticketsNumber=ticketsNumber-1 where id ="+ ShuttleID +" ");
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                Shuttle shuttle=new Shuttle();
                shuttle.setShuttleID(rs.getInt(1));
                shuttle.setStartTime(rs.getString(2));
                shuttle.setTicketsPrices(rs.getFloat(3));
                shuttle.setTicketsNumber(rs.getInt(4)-1);
                list.add(shuttle);
            }

            //System.out.println(list.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static String takeUserTrueName(String userName1)//通过用户名从数据库中取出对应的真实姓名
    {
        String userTrueName= null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","123456");

            PreparedStatement statement = connection.prepareStatement("SELECT trueName FROM user WHERE userName='"+ userName1 +"'");
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                userTrueName=rs.getString(1);
            }

           //System.out.println(userTrueName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userTrueName;
    }
    public static String takeStartTimeByShuttleID(Integer ShuttleID)//通过车票id取出发车时间
    {
        String timetemp = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","123456");

            PreparedStatement statement = connection.prepareStatement("select startTime FROM shuttle  where id ="+ ShuttleID +"");
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                //通过id取到对应车票的datetime 类型 的startTime，并通过getTimestamp方法和String.valueof()方法转换为字符串
                timetemp= String.valueOf(rs.getTimestamp(1));
            }
            //System.out.println(timetemp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return timetemp;
    }
    public static String takeStartStationByShuttleID(Integer ShuttleID)//通过车票id取出始发站信息
    {
        String startStation = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","123456");

            PreparedStatement statement = connection.prepareStatement("select startStation FROM shuttle  where id ="+ ShuttleID +"");
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                //通过id取到对应车票的datetime 类型 的startTime，并通过getTimestamp方法和String.valueof()方法转换为字符串
                startStation= rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return startStation;
    }
    public static String takeEndStationByShuttleID(Integer ShuttleID)//通过车票id取出终点站信息
    {
        String endStation = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","123456");

            PreparedStatement statement = connection.prepareStatement("select endStation FROM shuttle  where id ="+ ShuttleID +"");
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                //通过id取到对应车票的datetime 类型 的startTime，并通过getTimestamp方法和String.valueof()方法转换为字符串
                endStation= rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return endStation;
    }
}
