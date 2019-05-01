package com.ar4i.gifer.data.repositories;

import java.util.List;

import io.reactivex.Single;

public interface IGifsRepository {
    Single<List<String>> getGifUrls(String query, int limit);
}
