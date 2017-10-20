package ir.oveissi.daggersample.data.remote;

import ir.oveissi.daggersample.pojo.TmpMovies;
import retrofit2.Call;

/**
 * Created by abbas on 9/4/17.
 */

public class ApiService {
    private Api api;

    public ApiService(Api api) {
        this.api = api;
    }

    public Call<TmpMovies> getMovies(String query, Integer page)
    {
        return api.getMovies(query,page);
    }
}
