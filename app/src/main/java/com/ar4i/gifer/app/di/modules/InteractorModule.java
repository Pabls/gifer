package com.ar4i.gifer.app.di.modules;

import com.ar4i.gifer.data.repositories.GifsRepository;
import com.ar4i.gifer.domain.GifInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    GifInteractor provideGifInteractor(GifsRepository gifsRepository) {
        return new GifInteractor(gifsRepository);
    }
}
