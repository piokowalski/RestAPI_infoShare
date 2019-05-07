package com.infoshareacademy.api.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleResult {

    private StateDetails result;

    public SingleResult() {
    }

    public StateDetails getResult() {
        return result;
    }

    public void setResult(StateDetails result) {
        this.result = result;
    }
}
