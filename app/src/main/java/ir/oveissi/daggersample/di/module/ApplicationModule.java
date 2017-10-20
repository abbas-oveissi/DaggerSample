package ir.oveissi.daggersample.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.oveissi.daggersample.BuildConfig;

/**
 * Created by abbas on 9/4/17.
 */
@Module
public class ApplicationModule {
    @Provides
    @Singleton
    @Named("isDebug")
    public static boolean provideIsDebug() {
        return BuildConfig.DEBUG;
    }

    @Provides
    @Singleton
    @Named("networkTimeoutInSeconds")
    public static int provideNetworkTimeoutInSeconds() {
        return 30;
    }

    @Provides
    @Singleton
    @Named("BaseUrl")
    public static  String provideEndpoint() {
        return "http://moviesapi.ir";
    }

}
