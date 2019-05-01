package com.ar4i.gifer.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("data")
    @Expose
    private List<Gif> data;

    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<Gif> getData() {
        return data;
    }

    public void setData(List<Gif> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
