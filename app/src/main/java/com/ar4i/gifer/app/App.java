package com.ar4i.gifer.app;

import android.app.Application;

import com.ar4i.gifer.app.di.components.ApplicationComponent;
import com.ar4i.gifer.app.di.components.DaggerApplicationComponent;
import com.ar4i.gifer.app.di.modules.ApplicationModule;
import com.facebook.stetho.Stetho;

public class App extends Application {

    private static ApplicationComponent APPLICATION_COMPONENT;

    public static ApplicationComponent getApplicationComponent() {
        return APPLICATION_COMPONENT;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
        createComponent();
    }

    private void initStetho() {
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));
        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));
        Stetho.Initializer initializer = initializerBuilder.build();
        Stetho.initialize(initializer);
    }

    private void createComponent() {
        APPLICATION_COMPONENT = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
