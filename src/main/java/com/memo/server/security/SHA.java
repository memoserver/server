package com.memo.server.security;

import java.math.BigInteger;

public class SHA {
    public static final String KEY_SHA = "SHA";

    public static  String  getResult(String text)
    {
        //cipherthext
    //}
        BigInteger sha =null;
        System.out.println("=======加密前的数据:"+inputStr);
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            System.out.println("SHA加密后:" + sha.toString(32));
        } catch (Exception e) {e.printStackTrace();}
        return sha.toString(32);
    }

    public static void main(String args[])
    {
        try {
            String inputStr = "简单加密";
            getResult(inputStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
