package us.cijian.autumn.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import us.cijian.autumn.utils.SignUtils;

/**
 * Created by MurphyL on 2015/5/23.
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {

    @RequestMapping(method = RequestMethod.GET)
    public String settings(
            @RequestParam(required = false) String signature,
            @RequestParam(required = false) String timestamp,
            @RequestParam(required = false) String nonce,
            @RequestParam(required = false) String echostr
    ) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtils.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return timestamp;
    }

}
