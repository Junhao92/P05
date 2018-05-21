package com.example.a14049472.p05;

import java.io.Serializable;

public class Song implements Serializable {
    private int _id;
    private String title;
    private String singer;
    private int year;
    private int stars;

    public Song(String title, String singer, int year, int stars) {
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }
}
