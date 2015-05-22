package us.cijian.autumn.servlet; /**
 * Created by luohao4 on 2015/3/19.
 */

import us.cijian.autumn.config.Project;
import us.cijian.autumn.config.Wechat;
import us.cijian.autumn.mapper.SettingsMapper;
import us.cijian.autumn.pojo.Setting;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class BootstrapListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        System.setProperty("file.encoding", Project.ENCODING);

        /*MyBatisUtils.initMyBatisContext();
        SettingsMapper sm = MyBatisUtils.getMapper(SettingsMapper.class);
        List<Setting> settings = sm.getByType("wechat");
        for (Setting setting : settings) {
            Wechat.valueOf(setting.getName()).setVal(setting.getVal());
        }*/
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
