package com.codepath.moviemoose;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melissahuang on 7/18/16.
 */
public class NowPlayingMoviesResponse {

    @SerializedName("results")
    List<Movie> movieList;

    // public constructor is necessary for collections
    public NowPlayingMoviesResponse() {
        movieList = new ArrayList<Movie>();
    }

    public static NowPlayingMoviesResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        NowPlayingMoviesResponse nowPlayingMoviesResponse = gson.fromJson(response, NowPlayingMoviesResponse.class);
        return nowPlayingMoviesResponse;
    }
}
