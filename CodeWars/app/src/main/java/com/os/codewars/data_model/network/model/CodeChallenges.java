package com.os.codewars.data_model.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class CodeChallenges {

    @SerializedName("totalAuthored")
    @Expose
    private Integer totalAuthored;

    @SerializedName("totalCompleted")
    @Expose
    private Integer totalCompleted;

    public Integer getTotalAuthored() {
        return totalAuthored;
    }

    public void setTotalAuthored(Integer totalAuthored) {
        this.totalAuthored = totalAuthored;
    }

    public Integer getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(Integer totalCompleted) {
        this.totalCompleted = totalCompleted;
    }
}
