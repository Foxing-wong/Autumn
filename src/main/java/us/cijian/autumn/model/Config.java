package us.cijian.autumn.model;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;

import java.io.IOException;

/**
 * Created by Murphy on 2/15/2015.
 */
public final class Config {

    public final static Configuration init() throws IOException {
        Configuration configuration = new Configuration();
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        for (Resource resource : Resource.values()) {
            stringTemplateLoader.putTemplate(resource.name(), Resource.get(resource));
        }
        configuration.setTemplateLoader(stringTemplateLoader);
        return configuration;
    }

}
