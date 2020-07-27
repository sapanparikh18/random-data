package com.datagenerator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomUsaAddressShould {
    @Test
    public void return_a_random_usa_address(){
        RandomUsaAddress randomUsaAddress = new RandomUsaAddress();
        UsaAddress usaAddress = randomUsaAddress.next();
        Assertions.assertThat( usaAddress.getLat()).isNotNull().isNotEmpty().isNotBlank();
        Assertions.assertThat( usaAddress.getLon()).isNotNull().isNotEmpty().isNotBlank();
        Assertions.assertThat( usaAddress.getNumber()).isNotNull().isNotEmpty().isNotBlank();
        Assertions.assertThat( usaAddress.getStreet()).isNotNull().isNotEmpty().isNotBlank();
        Assertions.assertThat( usaAddress.getCity()).isNotBlank().isNotEmpty().isNotNull();
        Assertions.assertThat( usaAddress.getZip()).isNotBlank().isNotEmpty().isNotNull();
        Assertions.assertThat( usaAddress.getStateAcronym()).isNotNull().isNotEmpty().isNotBlank();
        System.out.println(usaAddress);
    }
}
