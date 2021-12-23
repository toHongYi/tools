package com.lyl.shunfeng.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class VerifyCodeUtil {
    /**
     * md5加密后转成base64返回
     *
     * @author Li Yulong
     * @date 2020-08-12 19:42
     * @param str 加密字符串
     * @return java.lang.String
     */
    public static String md5EncryptAndBase64(String str) {
        return Base64.getEncoder().encodeToString(md5Encrypt(str));
    }

    private static byte[] md5Encrypt(String encryptStr) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(encryptStr.getBytes(StandardCharsets.UTF_8));
            return md5.digest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDigest(String str) throws UnsupportedEncodingException {
        return md5EncryptAndBase64(URLEncoder.encode(str, "UTF-8"));
    }
}