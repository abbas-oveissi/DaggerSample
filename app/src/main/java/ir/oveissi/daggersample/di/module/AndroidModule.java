package ir.oveissi.daggersample.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.oveissi.daggersample.DaggerSampleApplication;

/**
 * Created by abbas on 9/4/17.
 */

@Module
public class AndroidModule {

    DaggerSampleApplication dsApplication;
    public AndroidModule(DaggerSampleApplication dsApplication) {
        this.dsApplication = dsApplication;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return dsApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    public Resources provideResources() {
        return dsApplication.getResources();
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(dsApplication);
    }
}
