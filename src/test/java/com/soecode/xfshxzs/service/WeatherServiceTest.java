package com.soecode.xfshxzs.service;

import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import com.soecode.xfshxzs.po.weather.Weather;

public class WeatherServiceTest {

	WeatherService weatherService = new WeatherService();

	@Test
	public void testGetWeather() throws JsonMappingException {
		String cityCode = weatherService.getCityCodeByCityName("珠海");
		Weather weather = weatherService.getWeatherByCityCode(cityCode);
		System.out.println(weather);
		System.out.println(weather.getToday());
		System.out.println(weather.getForecast());
		System.out.println(weather.getHistory());
	}

}
