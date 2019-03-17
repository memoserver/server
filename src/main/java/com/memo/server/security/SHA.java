package com.memo.server.security;
import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA {
    public static final String KEY_SHA = "SHA";

    public static String getResult(String text) {
        //ciphertext
        //}
        BigInteger sha = null;
        System.out.println("=======加密前的数据:" + text);
        byte[] inputData = text.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            System.out.println("SHA加密后:" + sha.toString(32));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sha.toString(32);
    }

    public static void main(String args[]) {
        try {
            String text = "1234";
            getResult(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
