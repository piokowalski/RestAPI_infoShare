package com.infoshareacademy.api.model;

import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipleResults {

    private List<StateDetails> result;

    public MultipleResults() {
    }

    public List<StateDetails> getResult() {
        return result;
    }

    public void setResult(List<StateDetails> result) {
        this.result = result;
    }
}
