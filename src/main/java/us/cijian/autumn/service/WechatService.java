package us.cijian.autumn.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.cijian.autumn.mapper.SettingsMapper;

/**
 * Created by MurphyL on 2015/5/22.
 */
@Service
public class WechatService {

    @Autowired
    private SettingsMapper settingsMapper;

    public void getAllSettings() {
        System.out.println(JSON.toJSONString(settingsMapper.getByType("wechat")));
    }

}
