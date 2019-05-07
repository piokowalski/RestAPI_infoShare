package com.infoshareacademy.api;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

class Translations {

    private List<Translation> translations;

    public Translations() {
    }

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }
}

class Translation {

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

class TranslationResult {

    private Translations data;

    public TranslationResult() {
    }

    public Translations getData() {
        return data;
    }

    public void setData(Translations data) {
        this.data = data;
    }
}