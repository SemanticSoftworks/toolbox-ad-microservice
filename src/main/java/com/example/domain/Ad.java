package com.example.domain;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Calendar;
import java.util.List;


@Entity(name = "Ad")
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adId;

    private long userId;

    private long categoryId;

    private String title;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar duration;

    private long[] photosId;

    public Ad(){}
    public Ad(long userId, long categoryId, String title, String description, Calendar duration, long[] photosIds) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.photosId = photosIds;
    }

    public long getAdId() {
        return adId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDuration() {
        return duration;
    }

    public void setDuration(Calendar duration) {
        this.duration = duration;
    }

    public long[] getPhotosIds() {
        return photosId;
    }

    public void setPhotos(byte[][] photos) {
        //this.photos = photos;
    }

   public void clearPhotos()
   {
       //this.photos = new ArrayList<>();
   }
}
