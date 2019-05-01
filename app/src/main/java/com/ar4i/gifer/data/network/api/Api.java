package com.ar4i.gifer.data.network.api;

import com.ar4i.gifer.data.network.request.Request;
import com.ar4i.gifer.data.network.response.ApiResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    static String VERSION = "v1";

    /**
     * http://api.giphy.com/v1/gifs/search?q=q&api_key=hllmd4VZaFn5d9odUITbdc5g70ItDLl2&limit=10
     */
    @GET(VERSION + "/gifs/search")
    Single<ApiResponse> getGifs(@Query(Request.QUERY) String searchQuery,
                                @Query(Request.LIMIT) int limit,
                                @Query(Request.API_KEY) String apiKey);
}
