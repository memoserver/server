package com.memo.server.entity.memo.pub;

import com.memo.server.entity.user.UserBase;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "public_id")
    private Set<PubImage> pubImages;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "public_id")
    private Set<PubTag> pubTags;

    private Date publishTime;

    private Date eventTime;

    private String location;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "public_id")
    private Set<Collection> collections;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "public_id")
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "public_id")
    private Set<Joining> joinings;

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

    public Set<PubImage> getPubImages() {
        return pubImages;
    }

    public void setPubImages(Set<PubImage> pubImages) {
        this.pubImages = pubImages;
    }

    public Set<PubTag> getPubTags() {
        return pubTags;
    }

    public void setPubTags(Set<PubTag> pubTags) {
        this.pubTags = pubTags;
    }

    public Set<Collection> getCollections() {
        return collections;
    }

    public void setCollections(Set<Collection> collections) {
        this.collections = collections;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Joining> getJoinings() {
        return joinings;
    }

    public void setJoinings(Set<Joining> joinings) {
        this.joinings = joinings;
    }
}
