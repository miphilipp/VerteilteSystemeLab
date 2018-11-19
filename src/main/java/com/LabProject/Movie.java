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

    // @ManyToOne
    // Director directors;

    // public Movie(String name, Date releaseDate) {
	// 	this.name = name;
	// 	this.releaseDate = releaseDate;
    // }
    
    // public Movie() {

    // }


    void setMovieId(Integer movieId) { this.movieId = movieId; }
    Integer getMovieId() { return movieId; }

    void setName(String name) { this.name = name; }
    String getName() { return name; }

    void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }
    Date getReleaseDate() { return releaseDate; }
    
}