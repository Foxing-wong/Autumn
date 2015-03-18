package us.cijian.autumn.config;

import us.cijian.autumn.dal.AbstractDal;
import us.cijian.autumn.dal.SettingsDal;

/**
 * Created by Murphy on 2/15/2015.
 */
public enum Resource {

    INDEX(SettingsDal.class),
    SETTINGS();

    private Class dalClass;

    Resource() {
    }

    <T extends AbstractDal> Resource(Class<T> dal) {
        this.dalClass = dal;
    }

    public boolean dynamic() {
        return null == dalClass;
    }

    public Class getDalClass() {
        return dalClass;
    }
}
