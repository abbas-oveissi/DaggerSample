package ir.oveissi.daggersample.di.module;

import dagger.Module;
import dagger.Provides;
import ir.oveissi.daggersample.data.DataManager;
import ir.oveissi.daggersample.data.local.MemoryCache;
import ir.oveissi.daggersample.data.remote.ApiService;
import ir.oveissi.daggersample.di.scope.PerActivity;

/**
 * Created by abbas on 9/5/17.
 */
@Module
public class DataModule {

    @PerActivity
    @Provides
    public DataManager provideDatamanager(ApiService apiService,
                                          MemoryCache cache)
    {
        return new DataManager(apiService,cache);
    }
}
