package com.wintergames.game1.model.stackoverflow;


import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "reputation",
        "user_id",
        "user_type",
        "accept_rate",
        "profile_image",
        "display_name",
        "link"
})
public class Owner {

    @JsonProperty("reputation")
    private long reputation;
    @JsonProperty("user_id")
    private long userId;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("accept_rate")
    private long acceptRate;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("link")
    private String link;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Owner() {
    }

    /**
     *
     * @param profileImage
     * @param link
     * @param userId
     * @param reputation
     * @param displayName
     * @param acceptRate
     * @param userType
     */
    public Owner(long reputation, long userId, String userType, long acceptRate, String profileImage, String displayName, String link) {
        this.reputation = reputation;
        this.userId = userId;
        this.userType = userType;
        this.acceptRate = acceptRate;
        this.profileImage = profileImage;
        this.displayName = displayName;
        this.link = link;
    }

    /**
     *
     * @return
     * The reputation
     */
    @JsonProperty("reputation")
    public long getReputation() {
        return reputation;
    }

    /**
     *
     * @param reputation
     * The reputation
     */
    @JsonProperty("reputation")
    public void setReputation(long reputation) {
        this.reputation = reputation;
    }

    public Owner withReputation(long reputation) {
        this.reputation = reputation;
        return this;
    }

    /**
     *
     * @return
     * The userId
     */
    @JsonProperty("user_id")
    public long getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The user_id
     */
    @JsonProperty("user_id")
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Owner withUserId(long userId) {
        this.userId = userId;
        return this;
    }

    /**
     *
     * @return
     * The userType
     */
    @JsonProperty("user_type")
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @param userType
     * The user_type
     */
    @JsonProperty("user_type")
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Owner withUserType(String userType) {
        this.userType = userType;
        return this;
    }

    /**
     *
     * @return
     * The acceptRate
     */
    @JsonProperty("accept_rate")
    public long getAcceptRate() {
        return acceptRate;
    }

    /**
     *
     * @param acceptRate
     * The accept_rate
     */
    @JsonProperty("accept_rate")
    public void setAcceptRate(long acceptRate) {
        this.acceptRate = acceptRate;
    }

    public Owner withAcceptRate(long acceptRate) {
        this.acceptRate = acceptRate;
        return this;
    }

    /**
     *
     * @return
     * The profileImage
     */
    @JsonProperty("profile_image")
    public String getProfileImage() {
        return profileImage;
    }

    /**
     *
     * @param profileImage
     * The profile_image
     */
    @JsonProperty("profile_image")
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Owner withProfileImage(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }

    /**
     *
     * @return
     * The displayName
     */
    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName
     * The display_name
     */
    @JsonProperty("display_name")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Owner withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     *
     * @return
     * The link
     */
    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    public Owner withLink(String link) {
        this.link = link;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Owner withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}

