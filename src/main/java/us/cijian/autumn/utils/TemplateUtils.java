package us.cijian.autumn.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import us.cijian.autumn.config.Resource;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Locale;
import java.util.Map;

/**
 * Created by luohao4 on 2015/3/17.
 */
public class TemplateUtils {

    private static Configuration config = null;

    private static StringTemplateLoader loader;

    private static TemplateUtils utils;

    public static TemplateUtils getInstance() {
        if(null == utils){
            utils = new TemplateUtils();
        }
        return utils;
    }

    private TemplateUtils() {
        config = new Configuration();
        loader = new StringTemplateLoader();
        config.setTemplateLoader(loader);
        try {
            loader.putTemplate("macro.ftl", FileReader.get("macro"));
            for (Resource resource : Resource.values()) {
                loader.putTemplate(FileReader.name(resource), FileReader.get(resource));
            }
            //config.setLocale(Locale.CHINA);
            config.setSetting("default_encoding", "UTF-8");
            config.setSetting("datetime_format", "yyyy-MM-dd HH:mm:ss");
            config.setSetting("content_type", "text/html; charset=utf-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void render(Resource res, HttpServletResponse response) throws IOException{
        SimpleHash root = new SimpleHash();
        Template template = config.getTemplate(FileReader.name(res));
        try{
            template.process(root, response.getWriter());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
