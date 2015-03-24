package com.nele.neleblog.model;

/**
 * Created by apple on 15/3/24.
 */
public class Tag {
    private  String id;
    private String content;

    public Tag() {
    }

    public Tag(String id, String content) {
        this.content = content;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "content='" + content + '\'' +
                ", id='" + id + '\'' +
                '}';
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
}
