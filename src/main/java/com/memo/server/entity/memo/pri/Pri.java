package com.memo.server.entity.memo.pri;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.memo.server.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "private")
@JsonIgnoreProperties(value = {"user"})
public class Pri implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int privateId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String title;

    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "privateId")
    private Set<PriImage> priImages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "privateId")
    private Set<PriTag> priTags;

    private Date publishTime;

    private Date alarmTime;

    private boolean urgent;

    public Pri() {
    }

    public Pri(User user, String title, String content, Set<PriImage> priImages, Set<PriTag> priTags, Date publishTime, Date alarmTime, boolean urgent) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.priImages = priImages;
        this.priTags = priTags;
        this.publishTime = publishTime;
        this.alarmTime = alarmTime;
        this.urgent = urgent;
    }

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
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

    public Set<PriImage> getPriImages() {
        return priImages;
    }

    public void setPriImages(Set<PriImage> priImages) {
        this.priImages = priImages;
    }

    public Set<PriTag> getPriTags() {
        return priTags;
    }

    public void setPriTags(Set<PriTag> priTags) {
        this.priTags = priTags;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }
}
