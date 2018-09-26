package com.readboy.ssm.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptHelper {

    public static String md5(String code) {
        try {
        	//实例化MessageDigest对象
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //对象重置
            digest.reset();
            //传送要计算的数据
            digest.update(code.getBytes());
            //生成信息摘要
            byte[] bt = digest.digest();
            //生成的信息摘要(字节数据)转为字符串
            StringBuffer sb = new StringBuffer();
            String temp = "";
            for (byte b : bt) {
                temp = Integer.toHexString(0xFF & b);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                sb.append(temp);
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (byte b : data) {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                buf.append((0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte) : (char) ('a' + (halfbyte - 10)));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString().toUpperCase();
    }

    public static String SHA1(String text, String charset) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(text.getBytes(charset), 0, text.length());
        byte[] sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
    
    public static void main(String args[]){
    	String fileName = "app_20170803.zip";
    	String password = "801225";
    	String passwdSecrete = EncryptHelper.md5(password);
    	String pwd = "202CB962AC59075B964B07152D234B70";
    	passwdSecrete = passwdSecrete.toUpperCase();
    	System.out.println(passwdSecrete);
    	if(pwd.equals(passwdSecrete)){
    		System.out.println("验证成功！");
    	}
    }
}