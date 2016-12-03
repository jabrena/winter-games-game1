package com.wintergames.game1.model.stackoverflow;


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
        "tags",
        "owner",
        "is_answered",
        "view_count",
        "answer_count",
        "score",
        "last_activity_date",
        "creation_date",
        "last_edit_date",
        "question_id",
        "link",
        "title"
})
public class Item {

    @JsonProperty("tags")
    @Valid
    private List<String> tags = new ArrayList<String>();
    @JsonProperty("owner")
    @Valid
    private Owner owner;
    @JsonProperty("is_answered")
    private boolean isAnswered;
    @JsonProperty("view_count")
    private long viewCount;
    @JsonProperty("answer_count")
    private long answerCount;
    @JsonProperty("score")
    private long score;
    @JsonProperty("last_activity_date")
    private long lastActivityDate;
    @JsonProperty("creation_date")
    private long creationDate;
    @JsonProperty("last_edit_date")
    private long lastEditDate;
    @JsonProperty("question_id")
    private long questionId;
    @JsonProperty("link")
    private String link;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Item() {
    }

    /**
     *
     * @param tags
     * @param creationDate
     * @param title
     * @param answerCount
     * @param questionId
     * @param link
     * @param lastActivityDate
     * @param isAnswered
     * @param score
     * @param owner
     * @param lastEditDate
     * @param viewCount
     */
    public Item(List<String> tags, Owner owner, boolean isAnswered, long viewCount, long answerCount, long score, long lastActivityDate, long creationDate, long lastEditDate, long questionId, String link, String title) {
        this.tags = tags;
        this.owner = owner;
        this.isAnswered = isAnswered;
        this.viewCount = viewCount;
        this.answerCount = answerCount;
        this.score = score;
        this.lastActivityDate = lastActivityDate;
        this.creationDate = creationDate;
        this.lastEditDate = lastEditDate;
        this.questionId = questionId;
        this.link = link;
        this.title = title;
    }

    /**
     *
     * @return
     * The tags
     */
    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     * The tags
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Item withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     *
     * @return
     * The owner
     */
    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    /**
     *
     * @param owner
     * The owner
     */
    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Item withOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    /**
     *
     * @return
     * The isAnswered
     */
    @JsonProperty("is_answered")
    public boolean isIsAnswered() {
        return isAnswered;
    }

    /**
     *
     * @param isAnswered
     * The is_answered
     */
    @JsonProperty("is_answered")
    public void setIsAnswered(boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    public Item withIsAnswered(boolean isAnswered) {
        this.isAnswered = isAnswered;
        return this;
    }

    /**
     *
     * @return
     * The viewCount
     */
    @JsonProperty("view_count")
    public long getViewCount() {
        return viewCount;
    }

    /**
     *
     * @param viewCount
     * The view_count
     */
    @JsonProperty("view_count")
    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public Item withViewCount(long viewCount) {
        this.viewCount = viewCount;
        return this;
    }

    /**
     *
     * @return
     * The answerCount
     */
    @JsonProperty("answer_count")
    public long getAnswerCount() {
        return answerCount;
    }

    /**
     *
     * @param answerCount
     * The answer_count
     */
    @JsonProperty("answer_count")
    public void setAnswerCount(long answerCount) {
        this.answerCount = answerCount;
    }

    public Item withAnswerCount(long answerCount) {
        this.answerCount = answerCount;
        return this;
    }

    /**
     *
     * @return
     * The score
     */
    @JsonProperty("score")
    public long getScore() {
        return score;
    }

    /**
     *
     * @param score
     * The score
     */
    @JsonProperty("score")
    public void setScore(long score) {
        this.score = score;
    }

    public Item withScore(long score) {
        this.score = score;
        return this;
    }

    /**
     *
     * @return
     * The lastActivityDate
     */
    @JsonProperty("last_activity_date")
    public long getLastActivityDate() {
        return lastActivityDate;
    }

    /**
     *
     * @param lastActivityDate
     * The last_activity_date
     */
    @JsonProperty("last_activity_date")
    public void setLastActivityDate(long lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Item withLastActivityDate(long lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
        return this;
    }

    /**
     *
     * @return
     * The creationDate
     */
    @JsonProperty("creation_date")
    public long getCreationDate() {
        return creationDate;
    }

    /**
     *
     * @param creationDate
     * The creation_date
     */
    @JsonProperty("creation_date")
    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public Item withCreationDate(long creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     *
     * @return
     * The lastEditDate
     */
    @JsonProperty("last_edit_date")
    public long getLastEditDate() {
        return lastEditDate;
    }

    /**
     *
     * @param lastEditDate
     * The last_edit_date
     */
    @JsonProperty("last_edit_date")
    public void setLastEditDate(long lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public Item withLastEditDate(long lastEditDate) {
        this.lastEditDate = lastEditDate;
        return this;
    }

    /**
     *
     * @return
     * The questionId
     */
    @JsonProperty("question_id")
    public long getQuestionId() {
        return questionId;
    }

    /**
     *
     * @param questionId
     * The question_id
     */
    @JsonProperty("question_id")
    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public Item withQuestionId(long questionId) {
        this.questionId = questionId;
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

    public Item withLink(String link) {
        this.link = link;
        return this;
    }

    /**
     *
     * @return
     * The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Item withTitle(String title) {
        this.title = title;
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

    public Item withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
