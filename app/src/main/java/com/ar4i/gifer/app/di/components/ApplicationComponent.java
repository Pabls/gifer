package com.ar4i.gifer.app.di.components;

import com.ar4i.gifer.app.App;
import com.ar4i.gifer.app.di.modules.ApplicationModule;
import com.ar4i.gifer.app.di.modules.InteractorModule;
import com.ar4i.gifer.app.di.modules.MappersModule;
import com.ar4i.gifer.app.di.modules.NetworkModule;
import com.ar4i.gifer.app.di.modules.PresentationModule;
import com.ar4i.gifer.app.di.modules.RepositoryModule;
import com.ar4i.gifer.presentation.main.view.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        InteractorModule.class,
        MappersModule.class,
        NetworkModule.class,
        PresentationModule.class,
        RepositoryModule.class
})
public interface ApplicationComponent {

    App application();

    void inject(MainFragment mainFragment);
}
