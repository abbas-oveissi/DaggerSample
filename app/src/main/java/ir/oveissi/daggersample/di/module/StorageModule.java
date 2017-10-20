package ir.oveissi.daggersample.di.module;

import dagger.Module;
import dagger.Provides;
import ir.oveissi.daggersample.data.local.MemoryCache;

/**
 * Created by abbas on 9/5/17.
 */
@Module
public class StorageModule {

    @Provides
    public MemoryCache provideCache() {
        return new MemoryCache(4 * 1024 * 1024);
    }

}
