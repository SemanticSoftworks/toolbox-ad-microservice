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
    private Calendar date;

    private long[] photosId;

    public Ad(){}
    public Ad(long userId, long categoryId, String title, String description, Calendar duration, long[] photosIds) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.date = duration;
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

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public long[] getPhotosIds() {
        return photosId;
    }

    public void setPhotosId(long[] photosId) {
        this.photosId = photosId;
    }

    public void clearPhotos()
   {
       //this.photos = new ArrayList<>();
   }
}
