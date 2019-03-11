package com.memo.server.entity.memo.pub;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "publicImage")
public class PubImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int publicImageId;

    private int public_id;

    private String image;

    public int getPublicImageId() {
        return publicImageId;
    }

    public void setPublicImageId(int publicImageId) {
        this.publicImageId = publicImageId;
    }

    public int getPublic_id() {
        return public_id;
    }

    public void setPublic_id(int public_id) {
        this.public_id = public_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
