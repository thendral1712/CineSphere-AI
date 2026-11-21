package com.mycompany.cinesphereai;

import java.util.ArrayList;

public class Actor {

    private String actorName;
    private ArrayList<Movie> movies;

    public Actor(String actorName) {
        this.actorName = actorName;
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public String getActorName() {
        return actorName;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}