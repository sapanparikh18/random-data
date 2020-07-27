package com.datagenerator;

public class UsaAddress {

    private String city;
    private String zip;
    private String stateAcronym;
    private String number;
    private String street;
    private String unit;
    private String lat;
    private String lon;

    @Override
    public String toString() {
        return "UsaAddress{" +
                "city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", stateAcronym='" + stateAcronym + '\'' +
                ", number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", unit='" + unit + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }

    public UsaAddress(String lat, String lon, String number, String street, String unit, String city, String stateAcronym, String zip) {
        this.lat = lat;
        this.lon = lon;
        this.unit = unit;
        this.street = street;
        this.number = number;
        this.city = city;
        this.zip = zip;
        this.stateAcronym = stateAcronym;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getStateAcronym() {
        return stateAcronym;
    }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getUnit() {
        return unit;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
}
