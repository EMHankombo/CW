package com.os.codewars.data_model.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class ChallengeDetails {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("approvedAt")
    @Expose
    private String approvedAt;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("rank")
    @Expose
    private ChallengeRank challengeRank;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("createdBy")
    @Expose
    private CreatedBy createdBy;
    @SerializedName("approvedBy")
    @Expose
    private ApprovedBy approvedBy;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("totalAttempts")
    @Expose
    private Integer totalAttempts;
    @SerializedName("totalCompleted")
    @Expose
    private Integer totalCompleted;
    @SerializedName("totalStars")
    @Expose
    private Integer totalStars;
    @SerializedName("voteScore")
    @Expose
    private Integer voteScore;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("contributorsWanted")
    @Expose
    private Boolean contributorsWanted;
    @SerializedName("unresolved")
    @Expose
    private Unresolved unresolved;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(String approvedAt) {
        this.approvedAt = approvedAt;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ChallengeRank getChallengeRank() {
        return challengeRank;
    }

    public void setChallengeRank(ChallengeRank challengeRank) {
        this.challengeRank = challengeRank;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public ApprovedBy getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(ApprovedBy approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalAttempts() {
        return totalAttempts;
    }

    public void setTotalAttempts(Integer totalAttempts) {
        this.totalAttempts = totalAttempts;
    }

    public Integer getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(Integer totalCompleted) {
        this.totalCompleted = totalCompleted;
    }

    public Integer getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(Integer totalStars) {
        this.totalStars = totalStars;
    }

    public Integer getVoteScore() {
        return voteScore;
    }

    public void setVoteScore(Integer voteScore) {
        this.voteScore = voteScore;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Boolean getContributorsWanted() {
        return contributorsWanted;
    }

    public void setContributorsWanted(Boolean contributorsWanted) {
        this.contributorsWanted = contributorsWanted;
    }

    public Unresolved getUnresolved() {
        return unresolved;
    }

    public void setUnresolved(Unresolved unresolved) {
        this.unresolved = unresolved;
    }

}
