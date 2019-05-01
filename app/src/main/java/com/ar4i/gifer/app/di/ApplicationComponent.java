package com.ar4i.gifer.app.di;

import com.ar4i.gifer.app.App;
import com.ar4i.gifer.presentation.main.view.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        PresentationModule.class
})
public interface ApplicationComponent {

    App application();

    void inject(MainFragment mainFragment);
}
