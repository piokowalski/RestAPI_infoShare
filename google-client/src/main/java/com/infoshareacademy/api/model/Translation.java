package com.infoshareacademy.api.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Translation {

    @JsonProperty("translatedText")
    private String text;

    public Translation() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
