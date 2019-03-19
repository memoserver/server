package com.memo.server.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@IdClass(Follow.class)
@Table(name = "follow")
public class Follow implements Serializable {

    @Id
    private int following_user_id;

    @Id
    private int followed_user_id;

    public Follow() {
    }

    public Follow(int following_user_id, int followed_user_id) {
        this.following_user_id = following_user_id;
        this.followed_user_id = followed_user_id;
    }

    public int getFollowing_user_id() {
        return following_user_id;
    }

    public void setFollowing_user_id(int following_user_id) {
        this.following_user_id = following_user_id;
    }

    public int getFollowed_user_id() {
        return followed_user_id;
    }

    public void setFollowed_user_id(int followed_user_id) {
        this.followed_user_id = followed_user_id;
    }
}
