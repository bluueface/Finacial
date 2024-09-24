package com.financial.framework;

public class Builder {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public Builder setStreet(String street) {
        this.street = street;
        return this;
    }

    public Builder setCity(String city) {
        this.city = city;
        return this;
    }

    public Builder setState(String state) {
        this.state = state;
        return this;
    }

    public Builder setZip(String zip) {
        this.zip = zip;
        return this;
    }
}
