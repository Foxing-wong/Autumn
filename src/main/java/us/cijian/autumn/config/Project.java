package us.cijian.autumn.config;

/**
 * Created by Murphy on 3/18/2015.
 */
public final class Project {

    public final static String ENCODING = "UTF-8";
    public final static String ENV_KEY = "autumn.env";
    public final static String PRODUCTION = "production";
    public final static String FTL_PATH = "/WEB-INF/classes/main/resources/template";
    public final static String MYBATIS_CONF = "/main/resources/mybatis/config.xml";

    public final static String ROOT = Project.class.getResource("/").getPath();

    public final static String FILE_SEPARATOR = System.getProperty("file.separator");

    public final static String DAL_PACKAGE = "us.cijian.autumn.mapper";
    public final static String DTO_PACKAGE = "us.cijian.autumn.pojo";

}
