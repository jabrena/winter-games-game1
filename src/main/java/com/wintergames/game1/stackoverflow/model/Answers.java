package com.wintergames.game1.stackoverflow.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "items",
        "has_more",
        "quota_max",
        "quota_remaining"
})
public class Answers {

    @JsonProperty("items")
    @Valid
    private List<Item> items = new ArrayList<Item>();
    @JsonProperty("has_more")
    private boolean hasMore;
    @JsonProperty("quota_max")
    private long quotaMax;
    @JsonProperty("quota_remaining")
    private long quotaRemaining;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Answers() {
    }

    /**
     *
     * @param hasMore
     * @param quotaMax
     * @param items
     * @param quotaRemaining
     */
    public Answers(List<Item> items, boolean hasMore, long quotaMax, long quotaRemaining) {
        this.items = items;
        this.hasMore = hasMore;
        this.quotaMax = quotaMax;
        this.quotaRemaining = quotaRemaining;
    }

    /**
     *
     * @return
     * The items
     */
    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Answers withItems(List<Item> items) {
        this.items = items;
        return this;
    }

    /**
     *
     * @return
     * The hasMore
     */
    @JsonProperty("has_more")
    public boolean isHasMore() {
        return hasMore;
    }

    /**
     *
     * @param hasMore
     * The has_more
     */
    @JsonProperty("has_more")
    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Answers withHasMore(boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }

    /**
     *
     * @return
     * The quotaMax
     */
    @JsonProperty("quota_max")
    public long getQuotaMax() {
        return quotaMax;
    }

    /**
     *
     * @param quotaMax
     * The quota_max
     */
    @JsonProperty("quota_max")
    public void setQuotaMax(long quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Answers withQuotaMax(long quotaMax) {
        this.quotaMax = quotaMax;
        return this;
    }

    /**
     *
     * @return
     * The quotaRemaining
     */
    @JsonProperty("quota_remaining")
    public long getQuotaRemaining() {
        return quotaRemaining;
    }

    /**
     *
     * @param quotaRemaining
     * The quota_remaining
     */
    @JsonProperty("quota_remaining")
    public void setQuotaRemaining(long quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    public Answers withQuotaRemaining(long quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
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

    public Answers withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}

