package com.video.store;

public class Movie {

    private final long id;
    private String title;
    private String overview;
    private String releaseDate;
    private int inventory;

    public Movie(long id, String content, String overview, String releaseDate, int inventory) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.inventory = inventory;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return title;
    }

}
