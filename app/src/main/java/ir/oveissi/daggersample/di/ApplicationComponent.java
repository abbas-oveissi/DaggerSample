package ir.oveissi.daggersample.di;

import javax.inject.Singleton;

import dagger.Component;
import ir.oveissi.daggersample.data.local.MemoryCache;
import ir.oveissi.daggersample.data.remote.ApiService;
import ir.oveissi.daggersample.di.module.AndroidModule;
import ir.oveissi.daggersample.di.module.ApplicationModule;
import ir.oveissi.daggersample.di.module.NetworkModule;
import ir.oveissi.daggersample.di.module.StorageModule;

/**
 * Created by abbas on 9/4/17.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        AndroidModule.class,
        NetworkModule.class,
        StorageModule.class
})
public interface ApplicationComponent {

    ApiService getApiService();
    MemoryCache getMemoryCache();

}
