package ir.oveissi.daggersample.di;

import javax.inject.Singleton;

import dagger.Component;
import ir.oveissi.daggersample.di.module.AndroidModule;
import ir.oveissi.daggersample.di.module.ApplicationModule;
import ir.oveissi.daggersample.di.module.DataModule;
import ir.oveissi.daggersample.di.module.NetworkModule;
import ir.oveissi.daggersample.di.module.StorageModule;
import ir.oveissi.daggersample.ui.FirstActivity;
import ir.oveissi.daggersample.ui.SecondActivity;

/**
 * Created by abbas on 9/4/17.
 */
@Singleton
@Component(modules = {
        DataModule.class,
        ApplicationModule.class,
        AndroidModule.class,
        NetworkModule.class,
        StorageModule.class
})
public interface ApplicationComponent {

    void inject(FirstActivity activity);
    void inject(SecondActivity activity);

}
