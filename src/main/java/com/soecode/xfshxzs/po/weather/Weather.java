package com.soecode.xfshxzs.po.weather;

import java.util.List;

/**
 * 天气实体
 */
public class Weather {

	// 城市名称
	private String city;

	// 城市ID
	private String cityid;

	// 今天天气
	private WeatherItem today;

	// 未来天气
	private List<WeatherItem> forecast;

	// 历史天气
	private List<WeatherItem> history;

	// 首页URL
	private String webUrl;

	// 逐小时URL
	private String hoursUrl;

	// 未来15天URL
	private String daysUrl;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public WeatherItem getToday() {
		return today;
	}

	public void setToday(WeatherItem today) {
		this.today = today;
	}

	public List<WeatherItem> getForecast() {
		return forecast;
	}

	public void setForecast(List<WeatherItem> forecast) {
		this.forecast = forecast;
	}

	public List<WeatherItem> getHistory() {
		return history;
	}

	public void setHistory(List<WeatherItem> history) {
		this.history = history;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getHoursUrl() {
		return hoursUrl;
	}

	public void setHoursUrl(String hoursUrl) {
		this.hoursUrl = hoursUrl;
	}

	public String getDaysUrl() {
		return daysUrl;
	}

	public void setDaysUrl(String daysUrl) {
		this.daysUrl = daysUrl;
	}

	@Override
	public String toString() {
		return "Weather [city=" + city + ", cityid=" + cityid + ", today=" + today + ", forecast=" + forecast
				+ ", history=" + history + ", webUrl=" + webUrl + ", hoursUrl=" + hoursUrl + ", daysUrl=" + daysUrl
				+ ", getCity()=" + getCity() + ", getCityid()=" + getCityid() + ", getToday()=" + getToday()
				+ ", getForecast()=" + getForecast() + ", getHistory()=" + getHistory() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
