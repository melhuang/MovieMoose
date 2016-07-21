package com.codepath.moviemoose;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by melissahuang on 7/20/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the movie for this position
        Movie movie = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        }
        // Lookup view for data population
        ImageView movieImageView = (ImageView) convertView.findViewById(R.id.movieImageView);
        int orientation = getContext().getResources().getConfiguration().orientation;
        String image;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso.with(getContext()).load(movie.poster_path).into(movieImageView);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Picasso.with(getContext()).load(movie.backdrop_path).into(movieImageView);
        }


        TextView movieTitle = (TextView) convertView.findViewById(R.id.movieTitle);
        TextView movieOverview = (TextView) convertView.findViewById(R.id.movieOverview);
        // Populate the data into the template view using the data object

        movieTitle.setText(movie.title);
        movieOverview.setText(movie.overview);

        // Return the completed view to render on screen
        return convertView;
    }
}
