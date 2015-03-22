package com.nele.neleblog.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by apple on 15/3/21.
 */
@Document(collection = "articles")
public class Article {

    private String id;

    private String title;

    private String content;

    private String ptime;

    private String category;

    private List<Reply> replies;

    public Article() {
    }

    public Article(String category, String content, String id, String ptime, String title) {
        this.category = category;
        this.content = content;
        this.id = id;
        this.ptime = ptime;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Articel{" +
                "category='" + category + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", ptime=" + ptime +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
