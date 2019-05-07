package com.infoshareacademy.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResult {

    private ErrorMessage error;

    public ErrorResult() {
    }

    public ErrorMessage getError() {
        return error;
    }

    public void setError(ErrorMessage error) {
        this.error = error;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ErrorMessage {

    private String message;

    public ErrorMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}