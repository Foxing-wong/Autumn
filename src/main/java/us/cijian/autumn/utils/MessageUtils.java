package us.cijian.autumn.utils;

import us.cijian.autumn.module.Project;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by MurphyL on 2015/5/16.
 */
public final class MessageUtils {

    private MessageUtils() {
    }

    public static <T> String bean2Xml(T bean) {
        try {
            Class tClass = bean.getClass();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            JAXBContext context = JAXBContext.newInstance(tClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, Project.ENCODING);
            marshaller.marshal(bean, stream);
            return stream.toString(Project.ENCODING);
        } catch (Exception e) {
            return "";
        }
    }

    public static <T> T xml2Bean(Class<T> tClass, String xml) {
        ByteArrayInputStream stream = null;
        try {
            stream = new ByteArrayInputStream(xml.getBytes(Project.ENCODING));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return xml2Bean(tClass, stream);
    }

    public static <T> T xml2Bean(Class<T> tClass, InputStream stream) {
        try {
            JAXBContext context = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(stream);
        } catch (Exception e) {
            return null;
        }
    }

}
