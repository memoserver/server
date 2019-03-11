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
    private int followingUserId;

    @Id
    private int followedUserId;
}
