package com.boot.security.server.utils;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
/**
 * 解密微信小程序登陆信息 encryptedData
 * @author sheng
 *
 */
public class AESHelper {

	private static boolean hasInited = false;
	  
    public static void init() {
        if (hasInited) {
            return;
        }  
        Security.addProvider(new BouncyCastleProvider());
        hasInited = true;
    }
	public static String AesDecrypt(String encryptedData, String sessionKey,String iv) {
        if (encryptedData == null || "".equals(encryptedData)) {
            return null;
        }
        init();
        byte[] sessionKeyByte = Base64.decodeBase64(sessionKey);
        byte[] ivByte = Base64.decodeBase64(PadRight(iv));
        byte[] encryptDataByte = Base64.decodeBase64(PadRight(encryptedData));
        try {  
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key key = new SecretKeySpec(sessionKeyByte, "AES");
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("AES");
            algorithmParameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, key, algorithmParameters);
            byte[] bytes = cipher.doFinal(encryptDataByte);
            
            return new String(bytes,"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return null;
    }

    public static String PadRight(String OldData) {
        //过滤特殊字符即可
        String NewData = OldData.trim().replace("%", "").replace(",", "").replace(" ", "+");
        StringBuffer buffer = new StringBuffer(NewData);
        if (buffer.length() % 4 > 0) {
        	int num = buffer.length() % 4;
        	for(int i=0;i<4-num;i++){
        		buffer.append("=");
        	}
        }
        return buffer.toString();
    }
}
