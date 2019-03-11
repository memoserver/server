package com.memo.server.entity.memo.pri;

import com.memo.server.entity.user.UserBase;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "private")
public class Pri implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int privateId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserBase user;

    private String title;

    private String content;

    @OneToMany
    @JoinColumn(name = "private_id")
    private List<PriImage> priImages;

    @OneToMany
    @JoinColumn(name = "private_id")
    private List<PriTag> priTags;

    private Date publishTime;

    private Date alarmTime;

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
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

    public List<PriImage> getPriImages() {
        return priImages;
    }

    public void setPriImages(List<PriImage> priImages) {
        this.priImages = priImages;
    }

    public List<PriTag> getPriTags() {
        return priTags;
    }

    public void setPriTags(List<PriTag> priTags) {
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
}
