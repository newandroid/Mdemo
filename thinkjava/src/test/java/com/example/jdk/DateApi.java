package com.example.jdk;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateApi {
    @Test
    public void sfd() {//直接百度比这个快一万倍
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println(sdf.format(System.currentTimeMillis()));
        Calendar instance = Calendar.getInstance();
        int var3 = instance.get(Calendar.DAY_OF_WEEK);
        if (var3 == 1) {
            var3 = 8;
        }
        StringBuilder var0 = new StringBuilder();
        String var1 = wtb[var3];
        var0.append(Character.toUpperCase(var1.charAt(0)));
        var0.append(var1.charAt(1)).append(var1.charAt(2));
        System.out.println(var0.toString());
        System.out.println(Calendar.getInstance().getTime());
    }

    private static final String[] wtb = new String[]{"am", "pm", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december", "gmt", "ut", "utc", "est", "edt", "cst", "cdt", "mst", "mdt", "pst", "pdt"};

    @Test
    public void baidu() {//week
        Calendar instance = Calendar.getInstance();
        long currentTime = instance.getTimeInMillis();
        long dayTime = 24 * 60 * 60 * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.ENGLISH);
        for (int i = 0; i < 7; i++) {
            long newTime = currentTime - i * dayTime;
            System.out.println(sdf.format(newTime));
        }

    }

    @Test
    public void baidu2() {//day
        Calendar instance = Calendar.getInstance();
        long current = instance.getTimeInMillis();
        instance.setTime(new Date());
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        long currentDayStart = instance.getTime().getTime();
        long oneHour = 60 * 60 * 1000;
        for (int i = 0; i < 24; i++) {
            long iWant = current - i * oneHour;
            SimpleDateFormat sdf = new SimpleDateFormat("ha", Locale.ENGLISH);
            String currentHour = sdf.format(iWant).toLowerCase();
            if (currentDayStart > iWant) {
                currentHour = currentHour + "(-1)";
            }
            System.out.println(currentHour);
        }


    }

    @Test
    public void baidu3() {//day
        Calendar instance = Calendar.getInstance();
        long currentTime = instance.getTimeInMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("LLL", Locale.ENGLISH);
        long dayTime = 24 * 60 * 60 * 1000;
        long weekTime = 7 * dayTime;
        for (int i = 0; i < 7; i++) {
            long nnncurrentTime = currentTime - i * weekTime;
            instance.setTimeInMillis(nnncurrentTime);
            System.out.println(String.format("%02d", instance.get(Calendar.DAY_OF_MONTH)) + sdf.format(nnncurrentTime));
        }

    }

    @Test
    public void baidu5() {//year
        Calendar instance = Calendar.getInstance();
        long currentTime = instance.getTimeInMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("LLL", Locale.ENGLISH);
        instance.setTime(new Date());
        instance.set(Calendar.YEAR, instance.get(Calendar.YEAR) - 1);
        long lastYear = instance.getTimeInMillis();
        int pointNumber = 7;
        long average = (currentTime - lastYear) / 7;
        for (int i = 0; i < pointNumber + 1; i++) {
            long nnncurrentTime = currentTime - i * average;
            instance.setTimeInMillis(nnncurrentTime);
            System.out.println(String.format("%02d", instance.get(Calendar.DAY_OF_MONTH)) + sdf.format(nnncurrentTime));
        }

    }

    @Test
    public void baidu4() {//day
        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR) - 2000;
        int month = instance.get(Calendar.MONTH);
        int totalMonth = month + year * 12;
        for (int i = 0; i < 8; i++) {
            int newTotalMonth = totalMonth - i * 3;
            int newYear = newTotalMonth / 12;
            int newMonth = newTotalMonth % 12;
            int quarter = (newMonth / 3) + 1;
            System.out.println(String.format("%02d", newYear) + "Q" + quarter);
        }

    }
}
