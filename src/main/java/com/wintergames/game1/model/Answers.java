package com.wintergames.game1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wintergames.game1.model.stackoverflow.Item;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "items"
})
@EqualsAndHashCode
public class Answers {

    @JsonProperty("items")
    @Getter
    private List<Item> items;

    public Answers(final List<Item> items){
        this.items = items;
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Answers(){

    }
}
