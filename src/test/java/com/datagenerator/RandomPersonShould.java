package com.datagenerator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RandomPersonShould {
    @Test
    public void create_person_with_random_name_and_address(){
        Person person = new RandomPerson().next();
        assertThat(person.getPersonName()).isNotNull();
        assertThat(person.getAddress()).isNotNull();
        System.out.println(person);
    }
}
