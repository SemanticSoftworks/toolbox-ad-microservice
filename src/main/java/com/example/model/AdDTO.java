package com.example.model;

import java.util.Calendar;

/**
 * Created by Teddy on 2017-02-08.
 */
public class AdDTO {

    private long adId;
    private long userId;
    private long category;
    private String title;
    private String description;
    private Calendar date;
    private long[] photosId;

    public AdDTO(long adId, long userId, long category, String title, String description, Calendar date, long[] photosId) {
        this.adId = adId;
        this.userId = userId;
        this.category = category;
        this.title = title;
        this.description = description;
        this.date = date;
        this.photosId = photosId;
    }

    public long[] getPhotosId() {
        return photosId;
    }
    public long getAdId() {
        return adId;
    }

    public long getUser() {
        return userId;
    }

    public long getCategoryId() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getDate() {
        return date;
    }
}
