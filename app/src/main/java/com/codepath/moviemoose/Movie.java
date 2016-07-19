package com.codepath.moviemoose;

import java.io.Serializable;

/**
 * Created by melissahuang on 7/18/16.
 */
public class Movie implements Serializable {
    boolean adult;
    String backdrop_path;
    int id;
    String title;
    String overview;
    String poster_path;

    Movie(boolean adult, String backdrop_path, int id, String title, String overview, String poster_path) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
    }
}
