package com.nele.neleblog.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by apple on 15/3/21.
 */
public class Reply {

    private String id;

    private String username;

    private String content;

    private LocalDateTime ptime;

    private String email;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getPtime() {
        return ptime;
    }

    public void setPtime(LocalDateTime ptime) {
        this.ptime = ptime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Reply() {
    }

    public Reply(String username, String content,  LocalDateTime ptime, String email) {
        this.content = content;
        this.email = email;
        this.id = id;
        this.ptime = ptime;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", ptime=" + ptime +
                ", email='" + email + '\'' +
                '}';
    }
}
