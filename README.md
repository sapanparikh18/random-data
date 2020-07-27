# Random Data Generator

Have you ever wondered how hard it is to generate random but meaningful data! That's what this random data generator utility does.

It can create random person names, random state acronyms, and random addresses with latitude and longitudes. 

Combining it all you can create a random person with a name, full address and gender.

### Use the following code to generate data
```java
package com.datagenerator;

public class Example {
    public static void main(String[] args) {
        Random random = new Random();
        Person person = random.nextPerson();
        PersonName personName = random.nextPersonName(Gender.Female);
        UsaAddress usaAddress = random.nextUsaAddress();
        String state = random.nextUsaState();
    }
}

``` 
