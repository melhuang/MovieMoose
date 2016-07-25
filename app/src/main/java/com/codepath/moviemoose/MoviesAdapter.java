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

    // URL constants
    final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p";
    final String POSTER_WIDTH = "/w154";
    final String BACKDROP_WIDTH = "/w780";

    // View Lookup cache
    private static class ViewModel {
        ImageView movieImageView;
        TextView movieTitle;
        TextView movieOverview;
    }

    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the movie for this position
        Movie movie = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewModel viewModel; // view lookup cache stored in tag
        if (convertView == null) {
            viewModel = new ViewModel();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);

            viewModel.movieTitle = (TextView) convertView.findViewById(R.id.movieTitle);
            viewModel.movieOverview = (TextView) convertView.findViewById(R.id.movieOverview);
            viewModel.movieImageView = (ImageView) convertView.findViewById(R.id.movieImageView);

            // Cache the viewModel, attach it to the view
            convertView.setTag(viewModel);
        } else {
            // View is being recycled, inflate with view model
            viewModel = (ViewModel) convertView.getTag();
        }


        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            String url = IMAGE_BASE_URL + POSTER_WIDTH + movie.poster_path;
            Picasso.with(getContext()).load(url).into(viewModel.movieImageView);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String url = IMAGE_BASE_URL + BACKDROP_WIDTH + movie.backdrop_path;
            Picasso.with(getContext()).load(url).into(viewModel.movieImageView);
        }
        // Populate the data into the template view using the data object
        viewModel.movieTitle.setText(movie.title);
        viewModel.movieOverview.setText(movie.overview);

        // Return the completed view to render on screen
        return convertView;
    }
}
