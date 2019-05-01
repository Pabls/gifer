package com.ar4i.gifer.app.di.modules;

import com.ar4i.gifer.data.mappers.GifsMapper;
import com.ar4i.gifer.data.network.api.Api;
import com.ar4i.gifer.data.repositories.GifsRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    GifsRepository provideGifsRepository(Api api, GifsMapper gifsMapper) {
        return new GifsRepository(api, gifsMapper);
    }
}
