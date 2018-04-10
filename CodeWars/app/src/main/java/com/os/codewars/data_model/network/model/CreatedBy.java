package com.os.codewars.data_model.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class CreatedBy {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("url")
    @Expose
    private String url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
