package us.cijian.autumn.pojo;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.ws.protocol.soap.MessageCreationException;
import org.junit.Test;
import us.cijian.autumn.utils.MessageUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by MurphyL on 2015/5/16.
 */
public class MessageTest {

    @Test
    public void testConvert2XML() throws MessageCreationException, JAXBException, IOException {
        Message message = new Message();
        message.setId("1");
        message.setContent("xasd");
        message.setCreateTime("21");

        String xml = MessageUtils.bean2Xml(message);

        System.out.printf(xml);

        Message message1 = MessageUtils.xml2Bean(Message.class, xml);

        System.out.print(JSON.toJSONString(message1, true));
    }


    @Test
    public void test(){
        String.format("%s", 1 < 0 ? 1l : "1");
        String.format("%s", 1 > 0 ? 1l : "1");
    }

}
