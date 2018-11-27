package com.LabProject;

import java.util.Date;
import javax.persistence.*;


/**
 * Movie
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer movieId;

    String name;
    Date releaseDate;

    @ManyToOne
    Director directors;

    // public Movie(String name, Date releaseDate) {
	// 	this.name = name;
	// 	this.releaseDate = releaseDate;
    // }
    
    public Movie() {
        super();
    }

    public Movie(String name, Date releaseDate) {
        super();
        this.releaseDate = releaseDate;
        this.name = name;
    }


    public void setMovieId(Integer movieId) { this.movieId = movieId; }
    public Integer getMovieId() { return movieId; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }
    public Date getReleaseDate() { return releaseDate; }
    
}