package com.infoshareacademy.api;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.infoshareacademy.api.model.StateDetails;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class StatesClientTest {

    private StatesClient client;

    @Before
    public void setUp() {
        client = new StatesClientImpl();
    }

    @Test
    public void shouldGetAllStates() {
        List<StateDetails> states = client.getAllStates();
        assertThat(states.size(), is(55));
    }

    @Test
    public void shouldGetState() {
        StateDetails state = client.getState("AZ");
        assertThat(state.getAbbr(), is("AZ"));
        assertThat(state.getName(), is("Arizona"));
        assertThat(state.getLargestCity(), is("Phoenix"));
        assertThat(state.getCapital(), is("Phoenix"));
    }
}