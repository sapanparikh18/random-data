package com.datagenerator;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RandomPersonNameShould {
    @Test
    public void should_generate_random_female_name(){
        RandomPersonName randomPersonName = new RandomPersonName();
        PersonName personName = randomPersonName.next(Gender.Female);

        String firstName = personName.getFirstName();
        String lastName = personName.getLastName();
        String middleInitial = personName.getMiddleInitial();
        assertThat(firstName).isNotBlank().isNotNull().isNotEmpty();
        assertThat(lastName).isNotBlank().isNotNull().isNotEmpty();
        assertThat(middleInitial).isNotNull().isNotEmpty().isNotBlank();

        System.out.println(personName);
    }

    @Test
    public void should_generate_random_male_name(){
        RandomPersonName randomPersonName = new RandomPersonName();
        PersonName personName = randomPersonName.next(Gender.Male);

        String firstName = personName.getFirstName();
        String lastName = personName.getLastName();
        String middleInitial = personName.getMiddleInitial();
        assertThat(firstName).isNotBlank().isNotNull().isNotEmpty();
        assertThat(lastName).isNotBlank().isNotNull().isNotEmpty();
        assertThat(middleInitial).isNotNull().isNotEmpty().isNotBlank();

        System.out.println(personName);
    }
}
