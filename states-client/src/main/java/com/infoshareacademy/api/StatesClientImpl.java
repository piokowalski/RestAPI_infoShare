package com.infoshareacademy.api;

import com.infoshareacademy.api.model.MultipleResults;
import com.infoshareacademy.api.model.MultipleResultsResponse;
import com.infoshareacademy.api.model.SingleResult;
import com.infoshareacademy.api.model.SingleResultResponse;
import com.infoshareacademy.api.model.StateDetails;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class StatesClientImpl implements StatesClient {

    private static final String URL = "http://services.groupkt.com/state/get/USA/";

    @Override
    public List<StateDetails> getAllStates() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL + "all");
        Response response = webTarget.request().get();

        MultipleResultsResponse result = response.readEntity(MultipleResultsResponse.class);
        MultipleResults multipleResults = result.getMultipleResults();

        List<StateDetails> states = multipleResults.getResult();
        return states;
    }

    @Override
    public StateDetails getState(String code) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL + code.toUpperCase());
        Response response = webTarget.request().get();

        SingleResultResponse result = response.readEntity(SingleResultResponse.class);
        SingleResult singleResult = result.getResult();

        StateDetails stateDetails = singleResult.getResult();
        return stateDetails;
    }
}