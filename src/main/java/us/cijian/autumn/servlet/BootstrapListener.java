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

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("上下文初始化中~");

        System.setProperty("file.encoding", Project.ENCODING);
        MyBatisContext.initMyBatisContext();

        SettingsMapper sm = MyBatisContext.getMapper(SettingsMapper.class);
        List<Setting> settings = sm.fetchAll();
        for (Setting setting : settings) {
            Wechat.valueOf(setting.getName()).setVal(setting.getVal());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
