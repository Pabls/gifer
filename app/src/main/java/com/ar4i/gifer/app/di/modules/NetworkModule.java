package com.ar4i.gifer.app.di.modules;

import com.ar4i.gifer.BuildConfig;
import com.ar4i.gifer.data.network.api.Api;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    StethoInterceptor provideStethoInterceptor() {
        return new StethoInterceptor();
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(StethoInterceptor stethoInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(BuildConfig.DEFAULT_CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS)
                .readTimeout(BuildConfig.DEFAULT_READ_TIMEOUT_SEC, TimeUnit.SECONDS)
                .addNetworkInterceptor(stethoInterceptor)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }
}
