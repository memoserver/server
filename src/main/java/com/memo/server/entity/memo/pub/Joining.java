    package com.memo.server.entity.memo.pub;

import com.memo.server.entity.user.UserBase;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(Joining.class)
@Table(name = "joining")
public class Joining implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserBase user;

    @Id
    @ManyToOne
    @JoinColumn(name = "public_id")
    private Pub pub;

    private Date time;

    public Joining(UserBase user, Pub pub, Date time) {
        this.user = user;
        this.pub = pub;
        this.time = time;
    }

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
