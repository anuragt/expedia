package com.expedia.weatherhelper.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.expedia.weatherhelper.form.City;

public class HelperTest {
	
	Helper helper=null;

	@Before
	public void setUp() throws Exception {
		helper=new Helper();
	}

	@After
	public void tearDown() throws Exception {
		helper=null;
	}

	@Test
	public void testGetCityInfoValidZip() {
		int zipCode=94117;
		City city= helper.getCityInfo(zipCode);
		assertEquals("San Francisco", city.getCityName());
		assertEquals("California", city.getState());
		
	}
	
	@Test
	public void testGetCityInfoInValidZip() {
		int zipCode=111111;
		City city= helper.getCityInfo(zipCode);
		assertNull(city);
		
	}

}
