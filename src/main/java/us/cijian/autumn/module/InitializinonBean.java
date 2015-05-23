package us.cijian.autumn.module;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.cijian.autumn.constants.Wechat;
import us.cijian.autumn.mapper.SettingsMapper;
import us.cijian.autumn.pojo.Setting;

import java.util.List;

/**
 * Created by MurphyL on 2015/5/23.
 */
@Component
public class InitializinonBean implements InitializingBean {

    @Autowired
    private SettingsMapper settingsMapper;

    public void afterPropertiesSet() throws Exception {
        List<Setting> settings = settingsMapper.getByType("wechat");
        for (Setting setting : settings) {
            Wechat.valueOf(setting.getName()).setVal(setting.getVal());
        }
    }
}
