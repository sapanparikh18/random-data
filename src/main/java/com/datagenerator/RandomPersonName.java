package com.datagenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomPersonName {
    Random random = new Random();

    public PersonName next(Gender gender) {
        try {
            String middleInitial = Character.toString ((char) (random.nextInt(26) + 'A'));
            return new PersonName(getFirstName(gender), getLastName(), middleInitial);
        } catch (URISyntaxException | IOException e) {
            throw new InternalError(e);
        }
    }

    private String getLastName() throws IOException, URISyntaxException {
        URL lastNamesFile = this.getClass().getClassLoader().getResource("last-names.txt");
        int lineToRead = getRandomLineToRead(lastNamesFile);
        return getName(lastNamesFile, lineToRead);
    }

    private String getFirstName(Gender gender) throws URISyntaxException, IOException {
        URL firstNamesFile = getFileUrl(gender);
        int lineToRead = getRandomLineToRead(firstNamesFile);
        return getName(firstNamesFile, lineToRead);
    }

    private String getName(URL file, int lineToRead) throws IOException, URISyntaxException {
        String name;
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(file.toURI()), StandardCharsets.UTF_8)) {
            List<String> listName = reader.lines()
                    .skip(lineToRead - 1)
                    .limit(1)
                    .collect(Collectors.toList());
            name = listName.get(0);
        }
        return name;
    }

    private int getRandomLineToRead(URL file) throws URISyntaxException, IOException {
        Path firstNamePath = Paths.get(file.toURI());
        long countOfLines = Files.lines(firstNamePath).parallel().count();
        return random.nextInt((int) countOfLines);
    }

    private URL getFileUrl(Gender gender) {
        URL file;
        if (gender.equals(Gender.Female)) {
            file = this.getClass().getClassLoader().getResource("female-first-names.txt");
        } else {
            file = this.getClass().getClassLoader().getResource("male-first-names.txt");
        }
        return file;
    }
}
