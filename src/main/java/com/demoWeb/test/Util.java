package com.demoWeb.test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

public class Util {
    public static void main(String[] args) {
       // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
      Date data=new Date();
        java.sql.Timestamp date=new java.sql.Timestamp(new Date().getTime());
     // String s=df.format(data);
       // System.out.println(data);// new Date()为获取当前系统时间
       // System.out.println(date);// new Date()为获取当前系统时间
        System.out.println(Util.getMd5("hello"));
        System.out.println(Util.getMd5("0215"));
        System.out.println(Util.getMd5("hello"));
        System.out.println();
        //String salt=Util.getCharAndNumr(5);
        //System.out.println(salt);
        String str="666666";
        System.out.println(Util.getMd5(str+"s4e2d"));

    }
    public static String getMd5(String pInput) {
        try {
            MessageDigest lDigest = MessageDigest.getInstance("MD5");
            lDigest.update(pInput.getBytes());
            BigInteger lHashInt = new BigInteger(1, lDigest.digest());
            return String.format("%1$032X", lHashInt);
        } catch (NoSuchAlgorithmException lException) {
            throw new RuntimeException(lException);
        }
    }
    public static String getCharAndNumr(int length) {
        Random random = new Random();
        StringBuffer valSb = new StringBuffer();
        String charStr = "0123456789abcdefghijklmnopqrstuvwxyz";
        int charLength = charStr.length();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charLength);
            valSb.append(charStr.charAt(index));
        }
        return valSb.toString();
    }



}
