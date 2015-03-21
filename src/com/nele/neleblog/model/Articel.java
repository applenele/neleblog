package com.nele.neleblog.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by apple on 15/3/21.
 */
@Document(collection = "article")
public class Articel {

    private String id;

    private String title;

    private String content;

    private LocalDateTime ptime;

    private String category;

    public Articel() {
    }

    public Articel(String category, String content, String id, LocalDateTime ptime, String title) {
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
}
