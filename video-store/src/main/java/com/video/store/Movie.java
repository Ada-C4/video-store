package com.video.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title, releaseDate;
    @Lob
    private String overview;
    private Long inventory;
    
    protected Movie() {}

    public Movie(String title, String overview, String releaseDate, Long inventory) {
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
    
    public Long getInventory() {
    	return inventory;
    }

}
