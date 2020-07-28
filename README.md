# Random Data Generator

Have you ever wondered how hard it is to generate random but meaningful data! 
That's what this random data generator Java library does.

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
The above program will generate data which will look somewhat like the following 

```JSON
Person{personName=PersonName{firstName='NIEVES', lastName='ALMONTE', middleInitial=W}, address=UsaAddress{city='HAMPSTEAD', zip='03841', stateAcronym='NH', number='6', street='WESTWOOD RD', unit='', lat='42.8791028', lon='-71.1897373'}, gender=Female}

```