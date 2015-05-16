package us.cijian.autumn.pojo;

/**
 * Created by MurphyL on 2015/5/16.
 */
public class TuringResponse {

    private static final int STATUS_CODE = 100000;

    private Integer code;
    private String text;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return null != code && code.equals(STATUS_CODE);
    }
}
