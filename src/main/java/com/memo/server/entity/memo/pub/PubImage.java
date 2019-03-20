package com.memo.server.entity.memo.pub;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "publicImage")
public class PubImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int publicImageId;

    private int publicId;

    private String image;

    public int getPublicImageId() {
        return publicImageId;
    }

    public void setPublicImageId(int publicImageId) {
        this.publicImageId = publicImageId;
    }

    public int getPublicId() {
        return publicId;
    }

    public void setPublicId(int publicId) {
        this.publicId = publicId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
