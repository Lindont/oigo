package com.aos.oigo.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 许湛司 on 2017/4/28.
 */
public class MD5Utils {

    /**
     * 把二进制数据转成md5二进制
     * @param binaryData
     * @return
     */
    public static byte[] calculateMd5(byte[] binaryData) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var3) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
        messageDigest.update(binaryData);
        return messageDigest.digest();
    }

    /**
     * 把md5二进制数据转成字符串
     * @param md5Buf
     * @return
     */
    public static String bytes2Md5Code(byte [] md5Buf){
        String result = "";
        for (int i = 0; i < md5Buf.length; i++) {
            result += Integer.toString((md5Buf[i] & 0xff) + 0x100, 16).substring(1);// 加0x100是因为有的b[i]的十六进制只有1位
        }
        return result;
    }

    public static String getMD5Code(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");// 获取一个实例，并传入加密方式
            digest.reset();// 清空一下
            digest.update(content.getBytes());// 写入内容,可以指定编码方式content.getBytes("utf-8");
            StringBuilder builder = new StringBuilder();
            for (byte b : digest.digest()) {
                builder.append(Integer.toHexString((b >> 4) & 0xf));
                builder.append(Integer.toHexString(b & 0xf));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMD5Code(String content,String charset){
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");// 获取一个实例，并传入加密方式
            digest.reset();// 清空一下
            digest.update(content.getBytes(charset));// 写入内容,可以指定编码方式content.getBytes("utf-8");
            StringBuilder builder = new StringBuilder();
            for (byte b : digest.digest()) {
                builder.append(Integer.toHexString((b >> 4) & 0xf));
                builder.append(Integer.toHexString(b & 0xf));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
