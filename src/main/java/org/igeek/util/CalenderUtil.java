package org.igeek.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Gyges on 2017/7/21.
 */
public class CalenderUtil {

    private static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String getFirstDayOfCurrentMonth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(STANDARD_FORMAT);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 0);//设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR,13);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return dateFormat.format(calendar.getTime());
    }

    public static String getLastDayOfCurrentMonth(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(STANDARD_FORMAT);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)-1);
        calendar.set(Calendar.HOUR,13);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return dateFormat.format(calendar.getTime());
    }

    public static void main(String[] args) {
        System.out.println(getFirstDayOfCurrentMonth());
        System.out.println(getLastDayOfCurrentMonth());
    }
}
