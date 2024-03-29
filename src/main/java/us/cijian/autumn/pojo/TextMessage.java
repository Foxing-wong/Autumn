package us.cijian.autumn.pojo;

import us.cijian.autumn.plugins.TuringPlugin;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by MurphyL on 2015/5/16.
 */
@XmlRootElement(name = "xml")
public class TextMessage extends Message {

    public TextMessage() {
        super(Type.text);
    }

    public TextMessage(Message message) {
        this(message, TuringPlugin.DEFAULT_MSG);
    }

    public TextMessage(Message message, String text) {
        this();
        this.setContent(text);
        this.setFromUserName(message.getToUserName());
        this.setToUserName(message.getFromUserName());
    }

}
