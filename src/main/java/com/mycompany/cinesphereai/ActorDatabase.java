package com.mycompany.cinesphereai;

import java.util.ArrayList;

public class ActorDatabase {

    private ArrayList<Actor> actors;

    public ActorDatabase() {

        actors = new ArrayList<>();

        // =========================
        // SHAH RUKH KHAN
        // =========================

        Actor srk = new Actor("Shah Rukh Khan");

        srk.addMovie(new Movie(
                "Jawan",
                "Azad",
                "Action",
                7.0,
                2023,
                2
        ));

        srk.addMovie(new Movie(
                "Dunki",
                "Hardy",
                "Drama",
                6.6,
                2023,
                1
        ));

        srk.addMovie(new Movie(
                "Pathaan",
                "Pathaan",
                "Action",
                5.8,
                2023,
                1
        ));

        actors.add(srk);


        // =========================
        // DEEPIKA PADUKONE
        // =========================

        Actor deepika = new Actor("Deepika Padukone");

        deepika.addMovie(new Movie(
                "Piku",
                "Piku",
                "Comedy Drama",
                7.6,
                2015,
                4
        ));

        deepika.addMovie(new Movie(
                "Chennai Express",
                "Meenamma",
                "Comedy",
                6.1,
                2013,
                3
        ));

        deepika.addMovie(new Movie(
                "Padmaavat",
                "Rani Padmavati",
                "Historical Drama",
                7.0,
                2018,
                5
        ));

        actors.add(deepika);


        // =========================
        // AAMIR KHAN
        // =========================

        Actor aamir = new Actor("Aamir Khan");

        aamir.addMovie(new Movie(
                "3 Idiots",
                "Rancho",
                "Comedy Drama",
                8.4,
                2009,
                6
        ));

        aamir.addMovie(new Movie(
                "Dangal",
                "Mahavir Singh Phogat",
                "Sports Drama",
                8.3,
                2016,
                7
        ));

        aamir.addMovie(new Movie(
                "PK",
                "PK",
                "Comedy Drama",
                8.1,
                2014,
                5
        ));

        actors.add(aamir);


        // =========================
        // LEONARDO DICAPRIO
        // =========================

        Actor leonardo = new Actor("Leonardo DiCaprio");

        leonardo.addMovie(new Movie(
                "Inception",
                "Cobb",
                "Sci-Fi Thriller",
                8.8,
                2010,
                4
        ));

        leonardo.addMovie(new Movie(
                "Titanic",
                "Jack Dawson",
                "Romance",
                7.9,
                1997,
                11
        ));

        leonardo.addMovie(new Movie(
                "The Revenant",
                "Hugh Glass",
                "Adventure Drama",
                8.0,
                2015,
                3
        ));

        actors.add(leonardo);


        // =========================
        // TOM HANKS
        // =========================

        Actor tom = new Actor("Tom Hanks");

        tom.addMovie(new Movie(
                "Forrest Gump",
                "Forrest Gump",
                "Drama",
                8.8,
                1994,
                6
        ));

        tom.addMovie(new Movie(
                "Cast Away",
                "Chuck Noland",
                "Drama",
                7.8,
                2000,
                2
        ));

        tom.addMovie(new Movie(
                "The Terminal",
                "Viktor Navorski",
                "Comedy Drama",
                7.4,
                2004,
                1
        ));

        actors.add(tom);
    }


    // SEARCH FOR AN ACTOR
    public Actor findActor(String name) {

        for (Actor actor : actors) {

            if (actor.getActorName().equalsIgnoreCase(name)) {
                return actor;
            }
        }

        return null;
    }
}