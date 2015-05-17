package us.cijian.autumn.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by MurphyL on 2015/5/17.
 * 利用 JSON 工具类完成序列化，没有注释的代码都有用呢~
 */
public class RiddleAnswer {

    @JSONField(name = "Content")
    private String content;
    /*@JSONField(name = "IsBestAnswer")
    private Boolean isBest;*/
    @JSONField(name = "SearchResults")
    private List<SearchResults> explains;

    public String getCleanExplain() {
        if (null == explains || explains.size() == 0) {
            return null;
        }
        String explain = explains.get(0).getSnippet();
        if(null != explain){
            explain = StringUtils.removeEnd(explain, "<br>");
            explain = explain.replaceAll("<br>", "，");
            explain = explain.replaceAll("——", "->");
        }
        return explain;
    }

    /*public String getContent() {
        return content;
    }*/

    public void setContent(String content) {
        this.content = content;
    }

    /*public Boolean getIsBest() {
        return isBest;
    }

    public void setIsBest(Boolean isBest) {
        this.isBest = isBest;
    }*/

    public void setExplains(List<SearchResults> explains) {
        this.explains = explains;
    }

    @Override
    public String toString() {
        return content + "：" + getCleanExplain();
    }

    public class SearchResults {
        @JSONField(name = "Snippet")
        private String snippet;

        public String getSnippet() {
            return snippet;
        }

        public void setSnippet(String snippet) {
            this.snippet = snippet;
        }
    }
}
