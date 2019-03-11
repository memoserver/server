package com.memo.server.entity.user;

import com.memo.server.entity.memo.pri.Pri;
import com.memo.server.entity.memo.pub.Collection;
import com.memo.server.entity.memo.pub.Comment;
import com.memo.server.entity.memo.pub.Joining;
import com.memo.server.entity.memo.pub.Pub;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    /**
     * 基本信息
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String account;

    private String photo;

    private String name;

    private int gender;

    private Date birth;

    private String phone;

    private String description;

    private String job;

    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Tag> tags;

    @ManyToMany
    @JoinTable(name="follow", joinColumns = {
            @JoinColumn(name="following_user_id",referencedColumnName = "userId")},inverseJoinColumns = {
            @JoinColumn(name="followed_user_id",referencedColumnName = "userId")})
    private List<UserBase> following;

    @ManyToMany
    @JoinTable(name="follow", joinColumns = {
            @JoinColumn(name="followed_user_id",referencedColumnName = "userId")},inverseJoinColumns = {
            @JoinColumn(name="following_user_id",referencedColumnName = "userId")})
    private List<UserBase> followed;

    /**
     * 私有
     */

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Pri> pris;

    /**
     * 公有
     */

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Pub> pubs;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Collection> collections;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Comment> comments;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Joining> joinings;

    /**
     * getter & setter
     */

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<UserBase> getFollowing() {
        return following;
    }

    public void setFollowing(List<UserBase> following) {
        this.following = following;
    }

    public List<UserBase> getFollowed() {
        return followed;
    }

    public void setFollowed(List<UserBase> followed) {
        this.followed = followed;
    }

    public List<Pri> getPris() {
        return pris;
    }

    public void setPris(List<Pri> pris) {
        this.pris = pris;
    }

    public List<Pub> getPubs() {
        return pubs;
    }

    public void setPubs(List<Pub> pubs) {
        this.pubs = pubs;
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
