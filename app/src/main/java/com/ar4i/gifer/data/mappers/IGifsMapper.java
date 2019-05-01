package com.ar4i.gifer.data.mappers;

import com.ar4i.gifer.data.network.response.ApiResponse;

import java.util.List;

public interface IGifsMapper {
    List<String> mapResponse(ApiResponse apiResponse);
}
