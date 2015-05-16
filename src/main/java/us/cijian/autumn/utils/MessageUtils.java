package us.cijian.autumn.utils;

import com.sun.xml.internal.ws.protocol.soap.MessageCreationException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by MurphyL on 2015/5/16.
 */
public final class MessageUtils {

    private MessageUtils() {
    }

    public static <T> String bean2Xml(T bean) throws MessageCreationException, JAXBException {
        Class tClass = bean.getClass();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        JAXBContext context = JAXBContext.newInstance(tClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(bean, stream);
        return stream.toString();
    }

    public static <T> T xml2Bean(Class<T> tClass, String xml) throws MessageCreationException, JAXBException {
        ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes());
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (T) jaxbUnmarshaller.unmarshal(stream);
    }

}
