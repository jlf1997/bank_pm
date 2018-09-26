package com.readboy.ssm.utils;

import org.apache.commons.io.IOUtils;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;

/**
 * Created by Administrator on 2018/3/13.
 */
public class CipherUtil {
    //使用AES算法进行加密
    private static String type = "AES";
    //定义的密钥
    private static String defaultKey = "BKJBHHIHUYGHRPPSDBKJ";
    
    /**
     * 加密文件srcFile保存到destFile，使用默认的密钥
     * @param srcFile
     * @param destFile
     */
    public static void encryptFile(String srcFile, String destFile) throws Exception{
        encryptFile(srcFile, destFile, defaultKey);
    }

    /**
     * 加密文件srcFile保存到destFile
     * @param srcFile
     * @param destFile
     * @param keyWord
     */
    public static void encryptFile(String srcFile, String destFile, String keyWord) throws Exception{
        Key key = generateKey(keyWord);
        Cipher cipher = Cipher.getInstance(type + "/ECB/PKCS5Padding");
        cipher.init(cipher.ENCRYPT_MODE, key);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(destFile);
            CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
            IOUtils.copy(cipherInputStream, outputStream);
            inputStream.close();
            outputStream.close();
        } catch (Throwable tx) {
            tx.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }

    }

    /**
     * 解密文件srcFile保存到destFile，使用默认的密钥
     * @param srcFile
     * @param destFile
     * @throws Exception
     */
    public static void decryptFile(String srcFile, String destFile) throws Exception{
        decryptFile(srcFile, destFile, defaultKey);
    }

    /**
     * 解密文件srcFile保存到destFile
     * @param srcFile
     * @param destFile
     * @param keyWord
     * @throws Exception
     */
    public static void decryptFile(String srcFile, String destFile, String keyWord) throws Exception{
        Key key = generateKey(keyWord);
        Cipher cipher = Cipher.getInstance(type + "/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(destFile);
            CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
            IOUtils.copy(cipherInputStream, outputStream);
            inputStream.close();
            outputStream.close();
        } catch (Throwable tx) {
            tx.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }
    }

    private static Key generateKey(String keyWord) throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance(type);
        keyGen.init(128, new SecureRandom(keyWord.getBytes()));
        SecretKey secretKey = keyGen.generateKey();
        return secretKey;
    }
    
    public static void main(String[] args) throws Exception{
    	//	encryptFile("D:\\a.txt", "D:\\b.txt", "123456");
        //	decryptFile("C://Users//lcl//Desktop//APP_DKKHCPXX.txt", "C://Users//lcl//Desktop//APP_DKKHCPXX.txt");
        encryptFile("C://Users//lcl//Desktop//APP_MYCUST.txt","C://Users//lcl//Desktop//App.txt");
        decryptFile("C://Users//lcl//Desktop//App.txt","C://Users//lcl//Desktop//end.txt");
    }


}

