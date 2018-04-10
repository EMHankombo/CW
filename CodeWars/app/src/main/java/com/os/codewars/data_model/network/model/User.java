package com.os.codewars.data_model.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class User {

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("leaderboardPosition")
    @Expose
    private Integer leaderboardPosition;

    @SerializedName("codeChallenges")
    @Expose
    private CodeChallenges codeChallenges;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLeaderboardPosition() {
        return leaderboardPosition;
    }

    public void setLeaderboardPosition(Integer leaderboardPosition) {
        this.leaderboardPosition = leaderboardPosition;
    }

    public CodeChallenges getCodeChallenges() {
        return codeChallenges;
    }

    public void setCodeChallenges(CodeChallenges codeChallenges) {
        this.codeChallenges = codeChallenges;
    }
}
