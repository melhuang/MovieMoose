package com.codepath.moviemoose;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.*;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends Activity {

    final String API_KEY = "7317527cae59a90e9b7f1a166d224d83";
    final String BASE_URL = "http://api.themoviedb.org/3";
    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchAllMovies();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Networking
    private void fetchAllMovies() {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://api.themoviedb.org/3/movie/now_playing?api_key=7317527cae59a90e9b7f1a166d224d83";
        client.get(url, null, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                Gson gson = new GsonBuilder().create();
                movieList = NowPlayingMoviesResponse.parseJSON(response).movieList;
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String error, Throwable t) {
//                public void onFailure(int statusCode, Header[] headers, String failure, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
//                System.out.println("failure: " + failure);

            }
        });
    }
}
