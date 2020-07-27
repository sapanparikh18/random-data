package com.datagenerator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomUsaStateShould {
    static  String[] states = new String[]
            {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    @Test
    public void generate_random_state_acronym(){
        RandomUsaState randomUsaState = new RandomUsaState();
        String state = randomUsaState.next();
        Assertions.assertThat(states).contains(state);
    }
}
