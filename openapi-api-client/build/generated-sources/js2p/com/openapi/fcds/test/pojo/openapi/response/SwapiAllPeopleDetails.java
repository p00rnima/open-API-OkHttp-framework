
package com.openapi.fcds.test.pojo.openapi.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Root Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "count",
    "next",
    "previous",
    "results"
})
public class SwapiAllPeopleDetails {

    /**
     * The count Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("count")
    private Integer count;
    /**
     * The next Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("next")
    private String next;
    /**
     * The previous Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("previous")
    private Object previous;
    /**
     * The results Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("results")
    private List<Result> results = new ArrayList<Result>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The count Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     * The count Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    public SwapiAllPeopleDetails withCount(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * The next Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    /**
     * The next Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
    }

    public SwapiAllPeopleDetails withNext(String next) {
        this.next = next;
        return this;
    }

    /**
     * The previous Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("previous")
    public Object getPrevious() {
        return previous;
    }

    /**
     * The previous Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("previous")
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public SwapiAllPeopleDetails withPrevious(Object previous) {
        this.previous = previous;
        return this;
    }

    /**
     * The results Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    /**
     * The results Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public SwapiAllPeopleDetails withResults(List<Result> results) {
        this.results = results;
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

    public SwapiAllPeopleDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
