package com.infoshareacademy.api;

import com.infoshareacademy.api.model.MultipleResults;
import com.infoshareacademy.api.model.MultipleResultsResponse;
import com.infoshareacademy.api.model.StateDetails;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class StatesClientImpl implements StatesClient {

    private static final String URL = "http://services.groupkt.com/state/get/USA/all";

    @Override
    public List<StateDetails> getAllStates() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL);
        Response response = webTarget.request().get();

        MultipleResultsResponse result = response.readEntity(MultipleResultsResponse.class);
        MultipleResults multipleResults = result.getMultipleResults();

        List<StateDetails> states = multipleResults.getResult();
        return states;
    }

    @Override
    public StateDetails getState(String code) {
        return getAllStates().stream()
            .filter(s -> s.getAbbr().equalsIgnoreCase(code))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
