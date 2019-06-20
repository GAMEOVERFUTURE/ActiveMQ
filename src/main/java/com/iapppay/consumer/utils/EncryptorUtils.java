package com.iapppay.consumer.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 * 简单加密和解密类
 * 
 * @author yuhao
 * @date 20130820
 */
public class EncryptorUtils {

	public static String Hex2String(byte[] data)
	{
	    StringBuilder hex = new StringBuilder(data.length * 2);
	    for (byte b : data) {
	        if ((b & 0xFF) < 0x10) hex.append("0");
	        hex.append(Integer.toHexString(b & 0xFF));
	    }
	    return hex.toString();
	}
	
	public static String md5(String string) {
	    byte[] hash;
	    try {
	        hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException("Huh, MD5 should be supported?", e);
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("Huh, UTF-8 should be supported?", e);
	    }
	    
	    return Hex2String(hash);
	}
	
	/** 
     * Base64解码 
     * @param key 
     * @return 
     */  
    public static byte[] decryptBASE64(String key){  
        return Base64.decodeBase64(key); 
        }  
      
    /** 
     * Base64编码 
     * @param sign 
     * @return 
     */  
    public static String encryptBASE64(byte[] sign){  
        return Base64.encodeBase64String(sign);  
    }
	
    private static final String PASSWD = "WWW.IAPPPAY.COM_YANGFENG";

	private static BasicTextEncryptor encryptor = new BasicTextEncryptor();

	static {
		encryptor.setPassword(PASSWD);
	}

    /** 加密 */
    public static String getEncryptionString(String message) {
        if (StringUtils.isBlank(message)) {
            return "";
        }
        try {
            String crymessage = encryptor.encrypt(message);
            if (crymessage == null) {
                return "";
            }
            return crymessage;
        } catch (Exception e) {
            return "";
        }

	}

    /** 解密 */
    public static String getDecryptionString(String encryptedMessage) {
        if (StringUtils.isBlank(encryptedMessage)) {
            return "";
        }
        try {
            String crymessage = encryptor.decrypt(encryptedMessage);
            if (crymessage == null) {
                return "";
            }
            return crymessage;
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String[] args) {
        String result = getEncryptionString("518cd310c27c3202f44e72e35fb5e1cb");

        String passwd = getDecryptionString("ux9nXx6yz331w9lLilv8ZQ==");
        System.out.println(result);
        System.out.println(passwd);
    }

}
