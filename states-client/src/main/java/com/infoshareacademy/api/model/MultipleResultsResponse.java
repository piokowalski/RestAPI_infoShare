package com.infoshareacademy.api.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class MultipleResultsResponse {

    @JsonProperty("RestResponse")
    private MultipleResults multipleResults;

    public MultipleResultsResponse() {
    }

    public MultipleResults getMultipleResults() {
        return multipleResults;
    }

    public void setMultipleResults(MultipleResults multipleResults) {
        this.multipleResults = multipleResults;
    }
}