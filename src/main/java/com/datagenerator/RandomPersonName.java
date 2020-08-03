package com.datagenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomPersonName {
    Random random = new Random();
    private final int NUM_LAST_NAMES = 88799;
    private final int NUM_FEMALE_NAMES = 4275;
    private final int NUM_MALE_NAMES = 1219;
    private BoundRandomInt boundRandomInt = new BoundRandomInt();

    public PersonName next(Gender gender) {
        try {
            String middleInitial = Character.toString((char) (random.nextInt(26) + 'A'));
            return new PersonName(getFirstName(gender), getLastName(), middleInitial);
        } catch (URISyntaxException | IOException e) {
            throw new InternalError(e);
        }
    }

    private String getLastName() throws IOException, URISyntaxException {
        InputStream lastNameStream = this.getClass().getClassLoader().getResourceAsStream("last-names.txt");
        boundRandomInt = new BoundRandomInt();
        int lineToRead = boundRandomInt.getRandomInteger(1, NUM_LAST_NAMES);
        return getName(lastNameStream, lineToRead);
    }

    private String getFirstName(Gender gender) throws URISyntaxException, IOException {
        InputStream firstNamesStream = getFileStream(gender);
        int lineToRead = getRandomLineToRead(gender);
        return getName(firstNamesStream, lineToRead);
    }

    private String getName(InputStream inputStream, int lineToRead) throws IOException, URISyntaxException {
        String name;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<String> listName = reader.lines()
                    .skip(lineToRead - 1)
                    .limit(1)
                    .collect(Collectors.toList());
            name = listName.get(0);
        }
        return name;
    }

    private int getRandomLineToRead(Gender gender) throws URISyntaxException, IOException {
        if (gender.equals(Gender.Female)) {
            return boundRandomInt.getRandomInteger(1, NUM_FEMALE_NAMES);
        }
        return boundRandomInt.getRandomInteger(1, NUM_MALE_NAMES);
    }

    private InputStream getFileStream(Gender gender) {
        InputStream inputStream;
        if (gender.equals(Gender.Female)) {
            inputStream = this.getClass().getClassLoader().getResourceAsStream("female-first-names.txt");
        } else {
            inputStream = this.getClass().getClassLoader().getResourceAsStream("male-first-names.txt");
        }
        return inputStream;
    }
}
