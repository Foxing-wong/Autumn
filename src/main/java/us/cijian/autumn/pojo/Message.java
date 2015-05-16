package us.cijian.autumn.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by MurphyL on 2015/5/16.
 */
@XmlRootElement(name = "xml")
public class Message {

    public Message() {
        this.setCreateTime(System.currentTimeMillis());
    }

    public enum Type {
        text;
    }

    @XmlElement(name = "MsgId")
    private String id;
    @XmlElement(name = "MsgType")
    private String type;
    @XmlElement(name = "Content")
    private String content;
    @XmlElement(name = "ToUserName")
    private String toUserName;
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    @XmlElement(name = "CreateTime")
    private String createTime;

    @XmlTransient
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlTransient
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setType(Type type) {
        this.setType(type.name());
    }

    @XmlTransient
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlTransient
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    @XmlTransient
    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    @XmlTransient
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = String.valueOf(createTime);
    }


    public boolean is(Type type) {
        return type.name().equals(this.type);
    }
}
