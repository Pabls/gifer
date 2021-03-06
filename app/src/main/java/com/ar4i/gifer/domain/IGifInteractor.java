package com.ar4i.gifer.domain;

import java.util.List;

import io.reactivex.Single;

public interface IGifInteractor {
    Single<List<String>> getGifUrls(String query, int limit);
}
