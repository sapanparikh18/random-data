package com.datagenerator;

import com.opencsv.CSVReaderHeaderAware;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomUsaAddress {
    Random random = new Random();

    public UsaAddress next() {
        int rowNum = getRandomInteger(0, 3491);
        try {
            return getUsaAddress(rowNum);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException();
        }
    }

    private UsaAddress getUsaAddress(int rowNum) throws URISyntaxException, IOException {
        URI fileUrl = getFileUrl();
        Map<String, String> address;
        address = read(rowNum, fileUrl);
        return new UsaAddress(address.get("LAT"),
                address.get("LON"),
                address.get("NUMBER"),
                address.get("STREET"),
                address.get("UNIT"),
                address.get("CITY"),
                address.get("REGION"),
                address.get("POSTCODE"));
    }

    private Map<String, String> read(int rowNum, URI fileUrl) throws IOException {
        Map<String, String> address;
        try (CSVReaderHeaderAware records = new CSVReaderHeaderAware(new FileReader(new File(fileUrl)))) {
            address = new HashMap<>();
            for (int i = 0; i < rowNum; i++) {
                address = records.readMap();
            }
        }
        return address;
    }

    private URI getFileUrl() throws URISyntaxException {
        return this.getClass().getClassLoader().getResource("addresses.csv").toURI();
    }

    public int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }


}
