package com.infoshareacademy.api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

public class GoogleTranslate {

    private final String API_KEY;

    public GoogleTranslate(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public String translate(String input, String source, String target) {

        String address = "https://translation.googleapis.com/language/translate/v2";

//                + "?key=" + API_KEY
//                + "&q=" + input
//                + "&source=" + source
//                + "&target=" + target;

        Form form = new Form();
        form.param("key", API_KEY);
        form.param("q",input);
        form.param("source", source);
        form.param("target", target);

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(address);
        Response response = webTarget.request().post(Entity.form(form));

        String result = response.readEntity(String.class);

        response.close(); // !!!!

        return result;
    }
}