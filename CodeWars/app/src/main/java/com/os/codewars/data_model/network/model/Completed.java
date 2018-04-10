package com.os.codewars.data_model.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class Completed {

    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;
    @SerializedName("data")
    @Expose
    private List<CompletedChallenges> data = null;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<CompletedChallenges> getData() {
        return data;
    }

    public void setData(List<CompletedChallenges> data) {
        this.data = data;
    }

}
