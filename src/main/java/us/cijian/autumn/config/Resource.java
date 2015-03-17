package us.cijian.autumn.config;

/**
 * Created by Murphy on 2/15/2015.
 */
public enum Resource {

    INDEX;

    public String ftl() {
        return this.name().toLowerCase() + ".ftl";
    }

}
