package com.memo.server.entity.memo.pub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.memo.server.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "collection")
@JsonIgnoreProperties(value = {"user", "pub"})
public class Collection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int collectionId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "publicId")
    private Pub pub;

    private Date time;

    public Collection() {
    }

    public Collection(User user, Pub pub, Date time) {
        this.user = user;
        this.pub = pub;
        this.time = time;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
