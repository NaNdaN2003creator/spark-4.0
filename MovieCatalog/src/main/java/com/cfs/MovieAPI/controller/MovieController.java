package com.cfs.MovieAPI.controller;

import com.cfs.MovieAPI.entity.Movie;
import org.apache.coyote.http11.filters.VoidInputFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/movies")
public class MovieController {

    //// simple in-memory store (HashMap). Data is lost on app restart.
    private final Map<Long, Movie> movieDB = new HashMap<>();
    //Get / movies - list all movies

    //Always return data wrapped in REspones Entrity
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return ResponseEntity.ok(new ArrayList<>(movieDB.values()));
    }

    //Post- /movies - add a movie
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){ //IF id is null or duplicates , you may to handle that later.

        movieDB.put(movie.getId(),movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    //GET - /Movies/{id} - feth movie details
    @GetMapping("/{id}") 
    public ResponseEntity<Movie> getMoviebyId(@PathVariable Long id)
    {
        Movie movie = movieDB.get(id);
        if(movie == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(movie);
    }

    // PUT /movies/{id} – edit movie details (full update)
    // PUT replaces the full resource. We make path id authoritative.

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMovie(@PathVariable Long id, @RequestBody Movie movie)
    {
        Movie existing = movieDB.get(id);
        if (existing == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // ensure the stored movie uses the path id
        movie.setId(id);
        movieDB.put(id, movie);
        return ResponseEntity.noContent().build();// 204 NO CONTENT
    }
    // DELETE /movies/{id} – delete a movie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id)
    {
        Movie removed = movieDB.remove(id);
        if (removed == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer year)
    {
        List<Movie> all = new ArrayList<>(movieDB.values());
        List<Movie> result = new ArrayList<>();

        for (Movie m : all)
        {
            // declare 'matches' inside loop at the start of each iteration
            boolean matches = true;

            if (genre != null && !genre.isBlank())
            {
                // case-insensitive genre match
                if (m.getGenre() == null || !m.getGenre().equalsIgnoreCase(genre)) {
                    matches = false;
                }
            }

            if (year != null)
            {
                // exact year match
                if (m.getReleaseYear() == null || !m.getReleaseYear().equals(year)) {
                    matches = false;
                }
            }

            if (matches) {
                result.add(m);
            }
        }

        return ResponseEntity.ok(result);
    }
}






