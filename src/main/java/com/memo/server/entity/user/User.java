package com.memo.server.entity.user;

import com.memo.server.entity.memo.pri.Pri;
import com.memo.server.entity.memo.pub.Collection;
import com.memo.server.entity.memo.pub.Comment;
import com.memo.server.entity.memo.pub.Joining;
import com.memo.server.entity.memo.pub.Pub;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

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

    private Boolean gender;

    private Date birth;

    private String phone;

    private String description;

    private String job;

    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Tag> tags;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="follow", joinColumns = {
            @JoinColumn(name="following_user_id",referencedColumnName = "userId")},inverseJoinColumns = {
            @JoinColumn(name="followed_user_id",referencedColumnName = "userId")})
    private Set<UserBase> following;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="follow", joinColumns = {
            @JoinColumn(name="followed_user_id",referencedColumnName = "userId")},inverseJoinColumns = {
            @JoinColumn(name="following_user_id",referencedColumnName = "userId")})
    private Set<UserBase> followed;

    /**
     * 私有
     */

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Pri> pris;

    /**
     * 公有
     */

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Pub> pubs;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Collection> collections;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Joining> joinings;

    public User() {
    }

    public User(int userId, String account) {
        this.userId = userId;
        this.account = account;
    }

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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<UserBase> getFollowing() {
        return following;
    }

    public void setFollowing(Set<UserBase> following) {
        this.following = following;
    }

    public Set<UserBase> getFollowed() {
        return followed;
    }

    public void setFollowed(Set<UserBase> followed) {
        this.followed = followed;
    }

    public Set<Pri> getPris() {
        return pris;
    }

    public void setPris(Set<Pri> pris) {
        this.pris = pris;
    }

    public Set<Pub> getPubs() {
        return pubs;
    }

    public void setPubs(Set<Pub> pubs) {
        this.pubs = pubs;
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
