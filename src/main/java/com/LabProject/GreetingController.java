package com.LabProject;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import java.util.*;


interface MovieRepository extends CrudRepository<Movie, Integer> { 
    Iterable<Movie> findAllByName(String name);
}

@RestController
public class GreetingController {

    @Autowired
    MovieRepository movieRepo;


    @PostMapping("/movie")
    public String addMovie(@RequestBody Movie newMovie) {
        Movie movie = new Movie();
        movie.setName(newMovie.getName());
        movie.setReleaseDate(newMovie.getReleaseDate());
        movieRepo.save(movie);
        return "OK";
    }

    @RequestMapping(value = "/movie", params = "id", method = RequestMethod.GET)
    public @ResponseBody Movie getMovieById(@RequestParam("id") String id) {
        Optional<Movie> movie = movieRepo.findById(Integer.parseInt(id));
        if (movie.isPresent()) {
            System.out.println("Film vorhanden");
            Movie m = movie.get();
            System.out.printf("Name: %s\n", m.getName());
            return m;
        } else {
            System.out.println("Film NICHT vorhanden");
            return null;
        }
    }

    @RequestMapping(value = "/movie", params="name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovieByName(@RequestParam("name") String name) {
        Iterable<Movie> movies = movieRepo.findAllByName(name);
        List<Movie> movieList = new ArrayList<Movie>();
        for (Movie m : movies) {
            movieList.add(m);
        }
        return movieList;
    }

    @GetMapping("/movie")
    public Iterable<Movie> getAllMovies() {
        System.out.println("Fio");
        System.out.println("Test");
        Iterable<Movie> findAll = movieRepo.findAll();
        ArrayList<String> arrayMovie = new ArrayList<String>();
        movieRepo.findAll().forEach(movie -> arrayMovie.add(movie.name));
        System.out.println(arrayMovie);

        return findAll;
    }
}