package demo1.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StringUtil {

    public static String dateToString(Date date)//将Date类数据转化为String类，由于数据库中发车时间信息是Date类，因此要将其输出展示时要转为String类
    {
        if(date==null)return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(date);

    }
}
