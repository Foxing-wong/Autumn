package us.cijian.autumn.config;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import us.cijian.autumn.utils.FileReader;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Murphy on 2/15/2015.
 */
public enum Resource {

    INDEX;

    public final void out(PrintWriter writer, Configuration cfg) throws IOException, TemplateException {
        try{
            cfg.getTemplate(FileReader.name(this)).process(null, writer);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
