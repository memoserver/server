package com.memo.server.entity.memo.pri;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@IdClass(PriTag.class)
@Table(name = "privateTag")
public class PriTag implements Serializable {

    @Id
    private int privateId;

    @Id
    private String tag;

    public PriTag() {
    }

    public PriTag(int privateId, String tag) {
        this.privateId = privateId;
        this.tag = tag;
    }

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
