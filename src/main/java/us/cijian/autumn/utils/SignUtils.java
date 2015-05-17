package us.cijian.autumn.utils;

import us.cijian.autumn.config.Wechat;
import us.cijian.autumn.pojo.WechatRequest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by luohao4 on 2015/3/19.
 */
public final class SignUtils {

    private SignUtils() {
    }

    private static final char[] DIGIT = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static String token = Wechat.TONKEN.getVal();

    /**
     * 验证签名
     *
     * @param request
     * @return
     */
    public static boolean checkSignature(WechatRequest request) {
        String[] arr = new String[]{token, request.getTimestamp(), request.getNonce()};
        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        String tmpStr = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(request.getSignature().toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] tempArr = new char[2];
        tempArr[0] = DIGIT[(mByte >>> 4) & 0X0F];
        tempArr[1] = DIGIT[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }

}
