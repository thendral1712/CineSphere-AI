package com.mycompany.cinesphereai;

import java.util.ArrayList;

public class CareerAnalyzer {

    public int getTotalMovies(Actor actor) {
        return actor.getMovies().size();
    }

    public double getAverageRating(Actor actor) {

        ArrayList<Movie> movies = actor.getMovies();

        double total = 0;

        for (Movie movie : movies) {
            total = total + movie.getRating();
        }

        if (movies.size() == 0) {
            return 0;
        }

        return total / movies.size();
    }

    public Movie getTopRatedMovie(Actor actor) {

        ArrayList<Movie> movies = actor.getMovies();

        if (movies.size() == 0) {
            return null;
        }

        Movie topMovie = movies.get(0);

        for (Movie movie : movies) {

            if (movie.getRating() > topMovie.getRating()) {
                topMovie = movie;
            }
        }

        return topMovie;
    }

    public int getTotalAwards(Actor actor) {

        int totalAwards = 0;

        for (Movie movie : actor.getMovies()) {
            totalAwards = totalAwards + movie.getAwards();
        }

        return totalAwards;
    }

    public String getAIInsight(Actor actor) {

        double average = getAverageRating(actor);
        int totalMovies = getTotalMovies(actor);
        int totalAwards = getTotalAwards(actor);

        if (average >= 8.5 && totalAwards >= 5) {

            return "Outstanding career! This actor shows consistently high-rated performances and strong award success.";

        } else if (average >= 8.0) {

            return "Strong career performance with consistently well-rated movies.";

        } else if (totalMovies >= 5) {

            return "An experienced actor with a diverse movie career.";

        } else {

            return "A promising career with opportunities for future growth.";
        }
    }
    public int getCareerScore(Actor actor) {

    double average = getAverageRating(actor);
    int awards = getTotalAwards(actor);
    int movies = getTotalMovies(actor);

    int score = 0;

    // Rating contributes up to 50 points
    score = score + (int)(average * 5);

    // Awards contribute up to 30 points
    score = score + Math.min(awards * 2, 30);

    // Movies contribute up to 20 points
    score = score + Math.min(movies * 4, 20);

    // Maximum score is 100
    if (score > 100) {
        score = 100;
    }

    return score;
}
    public String getCareerVerdict(Actor actor) {

    int score = getCareerScore(actor);

    if (score >= 80) {
        return "Highly Successful Career";
    } else if (score >= 60) {
        return "Strong Career";
    } else if (score >= 40) {
        return "Growing Career";
    } else {
        return "Emerging Career";
    }
}
   
}