package com.ar4i.gifer.data.repositories;

import com.ar4i.gifer.BuildConfig;
import com.ar4i.gifer.data.mappers.IGifsMapper;
import com.ar4i.gifer.data.network.api.Api;

import java.util.List;

import io.reactivex.Single;

public class GifsRepository implements IGifsRepository {

    public GifsRepository(Api api, IGifsMapper iGifsMapper) {
        this.api = api;
        this.iGifsMapper = iGifsMapper;
    }

    //==========================================start fields========================================
    private Api api;
    private IGifsMapper iGifsMapper;
    //-------------------------------------------end fields-----------------------------------------


    //==========================================start implements IGifsRepository====================
    @Override
    public Single<List<String>> getGifUrls(String query, int limit) {
        return api.getGifs(query, limit, BuildConfig.API_KEY)
                .map(apiResponse -> iGifsMapper.mapResponse(apiResponse));
    }
    //-------------------------------------------end implements IGifsRepository---------------------
}
