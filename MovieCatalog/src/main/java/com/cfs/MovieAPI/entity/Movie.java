package com.cfs.MovieAPI.entity;

public class Movie
{
    private Long id;      // unique id for each movie
    private String title;      // movie title
    private String genre;       // e.g. "action", "drama
    private Integer releaseYear;     // e.g. 2023
    private Double rating;        //e.g. 8.5

    public Movie(){

    }

    public Movie(Long id, String title, String genre, Integer releaseYear, Double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
