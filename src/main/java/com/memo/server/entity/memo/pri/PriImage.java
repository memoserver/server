package com.memo.server.entity.memo.pri;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "privateImage")
public class PriImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int privateImageId;

    private int privateId;

    private String image;

    public int getPrivateImageId() {
        return privateImageId;
    }

    public void setPrivateImageId(int privateImageId) {
        this.privateImageId = privateImageId;
    }

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
