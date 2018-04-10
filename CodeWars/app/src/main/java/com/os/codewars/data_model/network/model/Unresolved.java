package com.os.codewars.data_model.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Unresolved {

    @SerializedName("issues")
    @Expose
    private Integer issues;
    @SerializedName("suggestions")
    @Expose
    private Integer suggestions;

    public Integer getIssues() {
        return issues;
    }

    public void setIssues(Integer issues) {
        this.issues = issues;
    }

    public Integer getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(Integer suggestions) {
        this.suggestions = suggestions;
    }

}
