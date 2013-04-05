package com.expedia.weatherhelper.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class City {
	
	@Min(value=10000)
	@Max(value = 99999)
	int zipCode;
	
	String cityName;
	
	String state;
	
	float tempInF;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public float getTempInF() {
		return tempInF;
	}

	public void setTempInF(float tempInF) {
		this.tempInF = tempInF;
	}


	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}
