package com.ar4i.gifer.app.di.modules;

import com.ar4i.gifer.data.mappers.GifsMapper;

import dagger.Module;
import dagger.Provides;

@Module
public class MappersModule {

    @Provides
    GifsMapper provideGifsMapper() {
        return new GifsMapper();
    }
}
