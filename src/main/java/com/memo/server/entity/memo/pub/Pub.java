package com.memo.server.entity.memo.pub;

import com.memo.server.entity.user.UserBase;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "public")
public class Pub implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int public_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserBase user;

    private String title;

    private String content;

    @OneToMany
    @JoinColumn(name = "public_id")
    private List<PubImage> pubImages;

    @OneToMany
    @JoinColumn(name = "public_id")
    private List<PubTag> pubTags;

    private Date publishTime;

    private Date eventTime;

    private String location;

    @OneToMany
    @JoinColumn(name = "public_id")
    private List<Collection> collections;

    @OneToMany
    @JoinColumn(name = "public_id")
    private List<Comment> comments;

    @OneToMany
    @JoinColumn(name = "public_id")
    private List<Joining> joinings;

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

    public List<PubImage> getPubImages() {
        return pubImages;
    }

    public void setPubImages(List<PubImage> pubImages) {
        this.pubImages = pubImages;
    }

    public List<PubTag> getPubTags() {
        return pubTags;
    }

    public void setPubTags(List<PubTag> pubTags) {
        this.pubTags = pubTags;
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Joining> getJoinings() {
        return joinings;
    }

    public void setJoinings(List<Joining> joinings) {
        this.joinings = joinings;
    }
}
