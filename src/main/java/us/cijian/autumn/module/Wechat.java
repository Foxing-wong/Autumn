package us.cijian.autumn.module;

/**
 * Created by luohao4 on 2015/3/19.
 */
public enum Wechat {

    TONKEN,APP_ID,APP_SECRET,ENCODING_AES;

    private String val;

    Wechat() {
    }

    public void setVal(String val){
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
