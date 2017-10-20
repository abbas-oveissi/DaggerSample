package ir.oveissi.daggersample.data;

import java.util.List;

import ir.oveissi.daggersample.pojo.Movie;

/**
 * Created by abbas on 10/19/17.
 */

public interface DataCallback {
    void onSuccess(List<Movie> movies);

    void onFailure(String message);
}
