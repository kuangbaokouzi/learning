package com.laowuandhisfriends.di;

import java.util.List;

public class ChooseCity {
    private City chosenCity;
    private String chosenCityString;
    private String driverClass;
    private String homePath;
    private String charAt;
    private List<City> bigCities;
    private City firstBigCity;
    private City lastBigCity;
    private List<String> cityNames;

    public City getChosenCity() {
        return chosenCity;
    }

    public void setChosenCity(City chosenCity) {
        this.chosenCity = chosenCity;
    }

    public String getChosenCityString() {
        return chosenCityString;
    }

    public void setChosenCityString(String chosenCityString) {
        this.chosenCityString = chosenCityString;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getHomePath() {
        return homePath;
    }

    public void setHomePath(String homePath) {
        this.homePath = homePath;
    }

    public String getCharAt() {
        return charAt;
    }

    public void setCharAt(String charAt) {
        this.charAt = charAt;
    }

    public List<City> getBigCities() {
        return bigCities;
    }

    public void setBigCities(List<City> bigCities) {
        this.bigCities = bigCities;
    }

    public City getFirstBigCity() {
        return firstBigCity;
    }

    public void setFirstBigCity(City firstBigCity) {
        this.firstBigCity = firstBigCity;
    }

    public City getLastBigCity() {
        return lastBigCity;
    }

    public void setLastBigCity(City lastBigCity) {
        this.lastBigCity = lastBigCity;
    }

    public List<String> getCityNames() {
        return cityNames;
    }

    public void setCityNames(List<String> cityNames) {
        this.cityNames = cityNames;
    }
}
