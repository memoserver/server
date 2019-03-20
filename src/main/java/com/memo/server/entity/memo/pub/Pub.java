package com.memo.server.entity.memo.pub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.memo.server.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "public")
@JsonIgnoreProperties(value = {"user", "collections", "comments", "joinings"})
public class Pub implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int publicId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String title;

    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "publicId")
    private Set<PubImage> pubImages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "publicId")
    private Set<PubTag> pubTags;

    private Date publishTime;

    private Date eventTime;

    private String location;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "publicId")
    private Set<Collection> collections;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "publicId")
    private Set<Comment> comments;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "publicId")
    private Set<Joining> joinings;

    public int getPublicId() {
        return publicId;
    }

    public void setPublicId(int publicId) {
        this.publicId = publicId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
