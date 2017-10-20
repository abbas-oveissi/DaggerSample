package ir.oveissi.daggersample.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.oveissi.daggersample.data.DataManager;
import ir.oveissi.daggersample.data.local.MemoryCache;
import ir.oveissi.daggersample.data.remote.ApiService;

/**
 * Created by abbas on 9/5/17.
 */
@Module
public class DataModule {

    @Provides
    public DataManager provideDatamanager(ApiService apiService,
                                          MemoryCache cache)
    {
        return new DataManager(apiService,cache);
    }
}
