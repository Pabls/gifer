package com.ar4i.gifer.app.di;

import com.ar4i.gifer.presentation.main.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
