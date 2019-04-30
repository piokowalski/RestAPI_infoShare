package com.infoshareacademy.api;

import com.infoshareacademy.api.model.StateDetails;
import java.util.List;

public interface StatesClient {

    List<StateDetails> getAllStates();

    StateDetails getState(String code);

}
