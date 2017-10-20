package ir.oveissi.daggersample.data.remote;

import ir.oveissi.daggersample.pojo.TmpMovies;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by abbas on 9/4/17.
 */

public interface Api {

    //http://moviesapi.ir/api/v1/movies?q=[QUERY]&page=[PAGE]
    @GET("/api/v1/movies")
    Call<TmpMovies> getMovies(@Query("q") String query, @Query("page") Integer page);

}
