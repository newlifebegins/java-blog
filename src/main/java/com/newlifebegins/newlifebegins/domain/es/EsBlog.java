package com.newlifebegins.newlifebegins.domain.es;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * EsBlog 文档
 * @auth wangwei
 * @time 2019/12/5
 */
@Document(indexName = "blog",type = "blog")  // 文档
public class EsBlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id  // 主键
    private String id;
    private String title;
    private String summary;
    private String content;

    protected EsBlog() {  // JPA规范要求，防止直接使用

    }
    public EsBlog(String title,String summary,String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return String.format("EsBlog[id='%s',title='%s',summary='%s',content='%s']",id,title,summary,content);
    }
}
