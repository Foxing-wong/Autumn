package us.cijian.autumn.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import us.cijian.autumn.constants.Wechat;
import us.cijian.autumn.pojo.WechatRequest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by luohao4 on 2015/3/19.
 */
public final class SignUtils {

    private SignUtils() {
    }

    private static String token = Wechat.TONKEN.getVal();

    /**
     * 验证签名
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
        String sha1Content = getSHA1(token, request.getTimestamp(), request.getNonce());
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return sha1Content != null ? sha1Content.equals(request.getSignature()) : false;
    }

    public static String getSHA1(String token, String timestamp, String nonce) {
        return getSHA1(new String[]{token, timestamp, nonce});
    }

    public static String getShareConfig(String url) {
        String nonceStr = StringUtils.remove(UUID.randomUUID().toString(), "-");
        String timestamp = String.valueOf(System.currentTimeMillis());
        String signature = getSHA1(new String[]{token, url, timestamp, nonceStr});
        JSONObject config = new JSONObject();
        config.put("appId", Wechat.APP_ID.getVal());
        config.put("timestamp", timestamp);
        config.put("nonceStr", nonceStr);
        config.put("signature", signature);
        config.put("jsApiList", new String[]{
                "onMenuShareTimeline",
                "onMenuShareAppMessage",
                "onMenuShareQQ",
                "onMenuShareWeibo"
        });
        return config.toString();
    }

    /**
     * 用SHA1算法生成安全签名（from wechat demo）
     *
     * @param array
     * @return 安全签名
     * @throws Exception
     */
    public static String getSHA1(String[] array) {
        StringBuffer sb = new StringBuffer();
        // 字符串排序
        Arrays.sort(array);
        for (int i = 0, len = array.length; i < len; i++) {
            sb.append(array[i]);
        }
        String str = sb.toString();
        // SHA1签名生成
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(str.getBytes());
        byte[] digest = md.digest();
        StringBuffer hexstr = new StringBuffer();
        String shaHex = "";
        for (int i = 0; i < digest.length; i++) {
            shaHex = Integer.toHexString(digest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexstr.append(0);
            }
            hexstr.append(shaHex);
        }
        return hexstr.toString();
    }

}
