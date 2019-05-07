package com.infoshareacademy.api.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleResultResponse {

    @JsonProperty("RestResponse")
    private SingleResult result;

    public SingleResultResponse() {
    }

    public SingleResult getResult() {
        return result;
    }

    public void setResult(SingleResult result) {
        this.result = result;
    }
}