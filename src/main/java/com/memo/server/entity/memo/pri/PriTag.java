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
    private int private_id;

    @Id
    private String tag;

    public PriTag() {
    }

    public PriTag(int private_id, String tag) {
        this.private_id = private_id;
        this.tag = tag;
    }

    public int getPrivate_id() {
        return private_id;
    }

    public void setPrivate_id(int private_id) {
        this.private_id = private_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
