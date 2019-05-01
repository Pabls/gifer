package com.ar4i.gifer.app.di.modules;

import com.ar4i.gifer.domain.GifInteractor;
import com.ar4i.gifer.presentation.main.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    public MainPresenter provideMainPresenter(GifInteractor gifInteractor) {
        return new MainPresenter(gifInteractor);
    }
}
