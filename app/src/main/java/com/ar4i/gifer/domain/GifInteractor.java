package com.ar4i.gifer.domain;

import com.ar4i.gifer.data.repositories.IGifsRepository;

import java.util.List;

import io.reactivex.Single;

public class GifInteractor implements IGifInteractor {

    public GifInteractor(IGifsRepository iGifsRepository) {
        this.iGifsRepository = iGifsRepository;
    }

    //==========================================start fields========================================
    IGifsRepository iGifsRepository;
    //-------------------------------------------end fields-----------------------------------------


    //==========================================start implements IGifInteractor=====================
    @Override
    public Single<List<String>> getGifUrls(String query, int limit) {
        return iGifsRepository.getGifUrls(query, limit);
    }
    //-------------------------------------------end implements IGifInteractor----------------------

}
