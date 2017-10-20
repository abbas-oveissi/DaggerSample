package ir.oveissi.daggersample.di;

import dagger.Component;
import ir.oveissi.daggersample.di.module.DataModule;
import ir.oveissi.daggersample.di.scope.PerActivity;
import ir.oveissi.daggersample.ui.FirstActivity;
import ir.oveissi.daggersample.ui.SecondActivity;

/**
 * Created by abbas on 9/4/17.
 */
@PerActivity
@Component(modules = {DataModule.class},
        dependencies = {ApplicationComponent.class})
public interface ActivityComponent {

    void inject(FirstActivity activity);
    void inject(SecondActivity activity);

}