package com.infoshareacademy.api;

import java.util.List;

public class Translation {

    private String translatedText;

    public Translation() {
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}

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