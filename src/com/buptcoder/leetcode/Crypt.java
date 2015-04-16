package com.buptcoder.leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Crypt {
    private static String CRYPT_KEY = "www.591wifi.com";

    public static String crypt(String szBuf) {
        int x, y;
        y = 0;
        String back_str = "";
        byte[] temp_szKey = CRYPT_KEY.getBytes();
        byte[] temp_szBuf = szBuf.getBytes();
        byte[] end = new byte[szBuf.length()];
        for (x = 0; x < temp_szBuf.length; x++) {
            end[x] = (byte) ((temp_szBuf[x] & 0xF0) + ((temp_szBuf[x] & 0x0F) ^ (temp_szKey[y] & 0x0F)));
            y++;
            if (y >= CRYPT_KEY.length())
                y = 0;
        }
        back_str = new String(end);
        return back_str;
    }

    public static void main(String[] args) {
        String result = Crypt.crypt("654:0?6?");
        System.out.println(result);
        System.out.println(Crypt.crypt(result));
        SimpleDateFormat parseDate = new SimpleDateFormat(
                "yyyy-MM-DD HH:mm:ss.SSS", Locale.CHINA);
        try {
            Date date = parseDate.parse("2013-06-09 19:51:45.0");
            System.out.print("Time is:" + date.getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            System.out.print("Error");
            e.printStackTrace();
        }
    }
}