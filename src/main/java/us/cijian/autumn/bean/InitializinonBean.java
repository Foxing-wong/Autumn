package us.cijian.autumn.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import us.cijian.autumn.mapper.SettingsMapper;
import us.cijian.autumn.enums.Privileges;
import us.cijian.autumn.enums.Wechat;
import us.cijian.autumn.pojo.KV;
import us.cijian.autumn.pojo.Menu;
import us.cijian.autumn.pojo.MenuPack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by MurphyL on 2015/5/23.
 */
@Component
public class InitializinonBean implements InitializingBean {

    @Autowired
    private SettingsMapper settingsMapper;

    /*@Autowired
    private ApplicationContext applicationContext;*/

    public void afterPropertiesSet() throws Exception {
        // 微信公众号的配置信息
        List<KV<String, String>> settings = settingsMapper.getByType("wechat");
        if (!CollectionUtils.isEmpty(settings)) {
            for (KV<String, String> setting : settings) {
                Wechat.valueOf(setting.getK()).setVal(setting.getV());
            }
        }
        // 角色的从属关系
        List<KV<String, String>> roleMapping = settingsMapper.getSimpleRoleMapping();
        if (!CollectionUtils.isEmpty(roleMapping)) {
            for (KV<String, String> mapping : roleMapping) {
                Privileges.valueOf(mapping.getK()).add(mapping.getV());
            }
        }
        List<Menu> menus = settingsMapper.getAllMenus();
        Map<Integer, Menu> indexedMenusMapping = new HashMap<Integer, Menu>();
        for (Menu menu : menus) {
            indexedMenusMapping.put(menu.getId(), menu);
        }
        Map<String, MenuPack> menusMapping = new TreeMap<String, MenuPack>();
        List<KV<Integer, Integer>> menusIdMapping = settingsMapper.getMenusMapping();
        for (KV<Integer, Integer> mimap : menusIdMapping) {
            Menu main = indexedMenusMapping.get(mimap.getK());
            Menu slave = indexedMenusMapping.get(mimap.getV());
            Integer top = main.getTop();
            MenuPack pack = new MenuPack(main);
            if(null != top && top.equals(1)){
                pack.setParent(true);
                menusMapping.put(main.getName(), pack);
                continue;
            } if(menusMapping.containsKey(main.getName())){
                menusMapping.get(main.getName()).addMenu(slave);
            } else {
                pack.setParent(false);
                pack.addMenu(slave);
                menusMapping.put(main.getName(), pack);
            }

        }
        AppCache.cache("menusMapping", menusMapping);
    }
}
