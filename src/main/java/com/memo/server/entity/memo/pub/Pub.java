package com.memo.server.entity.memo.pub;

import com.memo.server.entity.user.User;
import com.memo.server.entity.user.UserBase;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "public")
public class Pub implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int public_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserBase user;

    private String title;

    private String content;

    private Date publishTime;

    private Date eventTime;

    private String location;

    public int getPublic_id() {
        return public_id;
    }

    public void setPublic_id(int public_id) {
        this.public_id = public_id;
    }

    public UserBase getUser() {
        return user;
    }

    public void setUser(UserBase user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
