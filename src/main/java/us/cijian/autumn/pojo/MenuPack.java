package us.cijian.autumn.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 子节点的图标和父节点保持一致
 * Created by MurphyL on 5/24/2015.
 */
public class MenuPack extends Menu {

    public MenuPack(Menu menu) {
        this.setId(menu.getId());
        this.setTop(menu.getTop());
        this.setName(menu.getName());
        this.setPath(menu.getPath());
        this.setIcon(menu.getIcon());
        this.setRole(menu.getRole());
        this.setSort(menu.getSort());
        this.setDescrption(menu.getDescrption());
    }

    private boolean parent;
    private List<Menu> menus;

    public boolean getParent() {
        return parent;
    }

    public void setParent(Boolean parent) {
        this.parent = parent;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void addMenu(Menu menu) {
        if (null == menus) {
            this.menus = new ArrayList<Menu>();
        }
        menus.add(menu);
    }
}
