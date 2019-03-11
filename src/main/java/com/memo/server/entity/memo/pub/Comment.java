package com.memo.server.entity.memo.pub;

import com.memo.server.entity.user.UserBase;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(Comment.class)
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserBase user;

    @Id
    @ManyToOne
    @JoinColumn(name = "public_id")
    private Pub pub;

    private String content;

    private Date time;

    public UserBase getUser() {
        return user;
    }

    public void setUser(UserBase user) {
        this.user = user;
    }

    public Pub getPub() {
        return pub;
    }

    public void setPub(Pub pub) {
        this.pub = pub;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
