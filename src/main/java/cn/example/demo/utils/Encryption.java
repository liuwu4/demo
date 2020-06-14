package cn.example.demo.utils;



import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author yj
 * 2020/6/14
 * @description 对用户密码加密
 **/
public class Encryption {
    /**
     * 生成加密后的密码
     *
     * @param password 用户输入的密码
     * @return 加密后的密码
     */
    public String generatorEncryption(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
           byte [] passwordByte =  password.getBytes();
           messageDigest.update(passwordByte);
           return Base64.encodeBase64String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
