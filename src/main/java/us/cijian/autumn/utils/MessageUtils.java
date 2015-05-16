package us.cijian.autumn.utils;

import com.sun.xml.internal.ws.protocol.soap.MessageCreationException;
import us.cijian.autumn.config.Project;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by MurphyL on 2015/5/16.
 */
public final class MessageUtils {

    private MessageUtils() {
    }

    public static <T> String bean2Xml(T bean) throws MessageCreationException, JAXBException, UnsupportedEncodingException {
        Class tClass = bean.getClass();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        JAXBContext context = JAXBContext.newInstance(tClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, Project.ENCODING);
        marshaller.marshal(bean, stream);
        return stream.toString(Project.ENCODING);
    }

    public static <T> T xml2Bean(Class<T> tClass, String xml) throws MessageCreationException, JAXBException, IOException {
        ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes(Project.ENCODING));
        return xml2Bean(tClass, stream);
    }

    public static <T> T xml2Bean(Class<T> tClass, InputStream stream) throws MessageCreationException, JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(stream);
    }

    public static String getStringFromStream(InputStream in) {
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int count = -1;
            while ((count = in.read(data, 0, 1024)) != -1)
                outStream.write(data, 0, count);

            data = null;
            return new String(outStream.toByteArray(), Project.ENCODING);
        } catch (Exception e) {
            return null;
        }
    }
}
