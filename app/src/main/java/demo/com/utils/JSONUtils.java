package demo.com.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import demo.com.data.Movie;

public class JSONUtils {

    private static final String KEY_RESULT = "results";
    private static final String KEY_VOTE_COUNT = "vote_count";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_ORIGINAL_TITLE = "originalTitle";
    private static final String KEY_OVERVIEW = "overview";
    private static final String KEY_POSTER_PATH = "posterPath";
    private static final String KEY_BACKDROP_PATH = "backdropPath";
    private static final String KEY_VOTE_AVERAGE = "voteAverage";
    private static final String KEY_RELEASE_DATE = "releaseDate";

    public static ArrayList<Movie> getMoviewFromJSON(JSONObject jsonObject) {

        ArrayList<Movie> result = new ArrayList<>();

        if (jsonObject == null) {
            return result;
        }

        try {
            JSONArray jsonArray = jsonObject.getJSONArray(KEY_RESULT);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject objectMovie = jsonArray.getJSONObject(i);
                int id = objectMovie.getInt(KEY_ID);
                int vote_count = objectMovie.getInt(KEY_VOTE_COUNT);
                String title = objectMovie.getString(KEY_TITLE);
                String originalTitle = objectMovie.getString(KEY_ORIGINAL_TITLE);
                String overview = objectMovie.getString(KEY_OVERVIEW);
                String posterPath = objectMovie.getString(KEY_POSTER_PATH);
                String backdropPath = objectMovie.getString(KEY_BACKDROP_PATH);
                double voteAverage = objectMovie.getDouble(KEY_VOTE_AVERAGE);
                String releaseDate = objectMovie.getString(KEY_RELEASE_DATE);
                result.add(new Movie(id, vote_count, title, originalTitle, overview, posterPath, backdropPath, voteAverage, releaseDate));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return result;

    }
}
