package com.memo.server.entity.memo.pri;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "privateImage")
public class PriImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int privateImageId;

    private int private_id;

    private String image;

    public int getPrivateImageId() {
        return privateImageId;
    }

    public void setPrivateImageId(int privateImageId) {
        this.privateImageId = privateImageId;
    }

    public int getPrivate_id() {
        return private_id;
    }

    public void setPrivate_id(int private_id) {
        this.private_id = private_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
