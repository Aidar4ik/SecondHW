package com.example.secondhw.data.models;

import com.google.gson.annotations.SerializedName;

public class Films {

    @SerializedName("title")
    private String title;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("description")
    private String description;

    @SerializedName("director")
    private String director;

    @SerializedName("producer")
    private String producer;

    public String getTitle() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
