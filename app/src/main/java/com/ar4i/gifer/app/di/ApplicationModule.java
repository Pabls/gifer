package com.ar4i.gifer.app.di;

import com.ar4i.gifer.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private App application;

    public ApplicationModule(App application) { this.application = application; }

    @Provides
    @Singleton
    App provideApplication() { return application; }
}