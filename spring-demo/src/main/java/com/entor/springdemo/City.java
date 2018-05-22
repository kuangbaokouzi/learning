package com.entor.springdemo;

import java.util.List;

/**
 * 城市
 * 
 * @author Administrator
 *
 */
public class City {
	public City() {
	}

	private String name;
	private String state;
	private int population;
	private City chosedCity;
	private List<City> bigCities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public City getChosedCity() {
		return chosedCity;
	}

	public void setChosedCity(City chosedCity) {
		this.chosedCity = chosedCity;
	}

	public List<City> getBigCities() {
		return bigCities;
	}

	public void setBigCities(List<City> bigCities) {
		this.bigCities = bigCities;
	}

}
