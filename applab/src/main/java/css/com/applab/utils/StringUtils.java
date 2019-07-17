package css.com.applab.utils;

import androidx.annotation.NonNull;

import java.nio.charset.StandardCharsets;

public class StringUtils {

    public static boolean isEmpty(String str) {
        if (str == null || str.trim().length() == 0)
            return true;
        else
            return false;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEquals(String str1, String str2) {

        return str1 == str2 || str1 != null && str1.equals(str2);
    }

    public static boolean isNotEquals(String str1, String str2) {
        return !isEquals(str1, str2);
    }

    public static String clearNull(@NonNull String input) {
        input = input.replaceAll("\u0000", "");
        int len = input.length();
        int st = 0;

        while ((st < len) && (input.charAt(st) <= ' ')) {
            st++;
        }
        while ((st < len) && (input.charAt(len - 1) <= ' ')) {
            len--;
        }
        return ((st > 0) || (len < input.length())) ? input.substring(st, len) : input;
    }

    public static String toUtf8(StringBuffer sb) {
        try {
            return new String(sb.toString().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);// "iso8859-1" gb2312
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }
}
