package com.mycompany.cinesphereai;

public class Movie {

    private String movieName;
    private String role;
    private String genre;
    private double rating;
    private int releaseYear;
    private int awards;

    public Movie(String movieName, String role, String genre,
                 double rating, int releaseYear, int awards) {

        this.movieName = movieName;
        this.role = role;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.awards = awards;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getRole() {
        return role;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getAwards() {
        return awards;
    }
}