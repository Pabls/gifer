package com.ar4i.gifer.data.mappers;

import com.ar4i.gifer.data.network.response.ApiResponse;
import com.ar4i.gifer.data.network.response.Gif;

import java.util.ArrayList;
import java.util.List;

public class GifsMapper implements IGifsMapper {


    @Override
    public List<String> mapResponse(ApiResponse apiResponse) {
        List<String> urls = new ArrayList<>();

        if (apiResponse != null && apiResponse.getData() != null && !apiResponse.getData().isEmpty()) {
            for (Gif gif : apiResponse.getData()) {
                if (gif != null && gif.getImages() != null && gif.getImages().getOriginal() != null) {
                    urls.add(gif.getImages().getOriginal().getUrl());
                }
            }
        }

        return urls;
    }
}
