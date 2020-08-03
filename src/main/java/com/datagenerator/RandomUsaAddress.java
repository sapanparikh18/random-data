package com.datagenerator;

import com.opencsv.CSVReaderHeaderAware;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomUsaAddress {
    Random random = new Random();
    BoundRandomInt boundRandomInt = new BoundRandomInt();
    public UsaAddress next() {
        int rowNum = boundRandomInt.getRandomInteger(1, 3491);
        try {
            return getUsaAddress(rowNum);
        } catch (IOException | URISyntaxException e) {
            throw new UnsupportedOperationException();
        }
    }

    private UsaAddress getUsaAddress(int rowNum) throws URISyntaxException, IOException {
        InputStream addressStream = getFileUrl();
        Map<String, String> address;
        address = read(rowNum, addressStream);
        return new UsaAddress(address.get("LAT"),
                address.get("LON"),
                address.get("NUMBER"),
                address.get("STREET"),
                address.get("UNIT"),
                address.get("CITY"),
                address.get("REGION"),
                address.get("POSTCODE"));
    }

    private Map<String, String> read(int rowNum, InputStream inputStream) throws IOException {
        Map<String, String> address;
        try (CSVReaderHeaderAware records = new CSVReaderHeaderAware(new InputStreamReader(inputStream))) {
            address = new HashMap<>();
            for (int i = 0; i < rowNum; i++) {
                address = records.readMap();
            }
        }
        return address;
    }

    private InputStream getFileUrl() throws URISyntaxException {
        return this.getClass().getClassLoader().getResourceAsStream("addresses.csv");
    }


}
