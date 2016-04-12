package com.video.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title, overview, releaseDate;
    private int inventory;
    
    protected Movie() {}

    public Movie(String title, String overview, String releaseDate, int inventory) {
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.inventory = inventory;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Movie[id=%d, title='%s', inventory='%s']",
                id, title, inventory);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    public String getOverview() {
    	return overview;
    }
    
    public String getReleaseDate() {
    	return releaseDate;
    }
    
    public int getInventory() {
    	return inventory;
    }

}
