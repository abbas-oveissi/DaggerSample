package ir.oveissi.daggersample.data;

import android.util.Log;

import ir.oveissi.daggersample.data.local.MemoryCache;
import ir.oveissi.daggersample.data.remote.ApiService;
import ir.oveissi.daggersample.pojo.TmpMovies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by abbas on 9/5/17.
 */
public class DataManager {

    private final ApiService apiService;
    private final MemoryCache cache;

    public DataManager(ApiService apiService, MemoryCache cache)
    {
        this.apiService = apiService;
        this.cache = cache;
    }

    public void getMovies(Integer page,final DataCallback dataCallback)
    {
        String key="page='"+page+"'";

        if(cache.get(key)!=null)
        {
            Log.d("DaggerSample","get page "+page.toString()+" from cache.");
            dataCallback.onSuccess(((TmpMovies) cache.get(key)).data);
        }
        else
        {
            Log.d("DaggerSample","get page "+page.toString()+" from internet.");
            apiService.getMovies("",page).enqueue(new Callback<TmpMovies>() {
                @Override
                public void onResponse(Call<TmpMovies> call, Response<TmpMovies> response) {
                    String key="page='"+response.body().metadata.current_page+"'";
                    cache.add(key,response.body());
                    dataCallback.onSuccess(response.body().data);
                }

                @Override
                public void onFailure(Call<TmpMovies> call, Throwable t) {
                    dataCallback.onFailure(t.getMessage());
                }
            });
        }


    }
}
