package com.nele.neleblog.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by apple on 15/3/27.
 */

@Document(collection = "messages")
public class Message {

    private String id;

    private String nickname;

    private String content;

    private String mtime;

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

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", mtime='" + mtime + '\'' +
                '}';
    }


    public Message() {
    }

    public Message( String id,String nickname, String content,String mtime) {
        this.content = content;
        this.id = id;
        this.mtime = mtime;
        this.nickname = nickname;
    }
}
