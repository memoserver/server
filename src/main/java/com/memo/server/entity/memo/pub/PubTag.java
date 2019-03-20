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
    private int publicId;

    @Id
    private String tag;

    public int getPublicId() {
        return publicId;
    }

    public void setPublicId(int publicId) {
        this.publicId = publicId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
