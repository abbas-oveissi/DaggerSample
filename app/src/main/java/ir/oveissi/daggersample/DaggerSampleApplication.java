package ir.oveissi.daggersample;

import android.app.Application;

import ir.oveissi.daggersample.di.DaggerApplicationComponent;
import ir.oveissi.daggersample.di.module.AndroidModule;


/**
 * Created by abbas on 9/4/17.
 */

public class DaggerSampleApplication extends Application {
    static DaggerApplicationComponent dac;

    @Override
    public void onCreate() {
        super.onCreate();
        dac= (DaggerApplicationComponent) dac.builder()
                .androidModule(new AndroidModule(this))
                .build();
    }
    public static DaggerApplicationComponent getComponent()
    {
        return dac;
    }
}
