package com.os.codewars.data_model.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Authored {

    @SerializedName("data")
    @Expose
    private List<AuthoredChallenges> data = null;

    public List<AuthoredChallenges> getData() {
        return data;
    }

    public void setData(List<AuthoredChallenges> data) {
        this.data = data;
    }

}
