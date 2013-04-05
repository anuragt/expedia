package com.expedia.weatherhelper.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expedia.weatherhelper.form.City;
import com.expedia.weatherhelper.helper.Helper;

@Configuration
@Controller
@RequestMapping("/cityInfo")
public class CityInfoFormController {
	@Autowired
	private Helper helper;
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showCityDetails(@Valid City city, BindingResult result){
		if(result.hasErrors() || result.hasFieldErrors()){
			String message="invalid zip code format";
			return new ModelAndView("error","message",message);
		}
		int zipCode=city.getZipCode();		
		City cityInfo=helper.getCityInfo(zipCode);
		if(cityInfo==null){
			String message="zip code not found";
			return new ModelAndView("error","message",message);
		}
		return new ModelAndView("cityWeather","city",cityInfo);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView createForm(){
		return new ModelAndView("cityInput","city", new City());
	}

	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	
	

}
