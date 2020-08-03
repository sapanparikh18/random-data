package com.datagenerator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomPersonShould {
    @Test
    public void create_person_with_random_name_and_address(){
        Person person = new RandomPerson().next();
        assertThat(person.getPersonName()).isNotNull();
        assertThat(person.getAddress()).isNotNull();
    }
}