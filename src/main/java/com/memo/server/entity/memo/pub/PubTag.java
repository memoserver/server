package com.memo.server.entity.memo.pub;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@IdClass(PubTag.class)
@Table(name = "publicTag")
public class PubTag implements Serializable {

    @Id
    private int public_id;

    @Id
    private String tag;

    public int getPublic_id() {
        return public_id;
    }

    public void setPublic_id(int public_id) {
        this.public_id = public_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
