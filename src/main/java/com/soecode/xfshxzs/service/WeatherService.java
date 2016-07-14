package com.soecode.xfshxzs.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.soecode.xfshxzs.po.weather.Weather;
import com.soecode.xfshxzs.util.HttpUitl;

/**
 * 天气业务
 * 
 * {@link http://apistore.baidu.com/apiworks/servicedetail/112.html}
 */
public class WeatherService {
    
    // 项目根目录
    private static final String BASEPATH = "http://lyf.soecode.com/xfshxzs";

    // 百度API钥匙
    private static final String APIKEY = "***";

    // 城市代码查询
    private static final String CITY_CODE_URL = "http://apis.baidu.com/apistore/weatherservice/cityinfo";

    // 天气查询
    private static final String WEATHER_URL = "http://apis.baidu.com/apistore/weatherservice/recentweathers";

    // 中国天气网
    private static final String WEATHER_WEB_URL = "http://www.weather.com.cn/weather/CITYCODE.shtml";

    // 逐小时天气预报
    private static final String WEATHER_HOURS_URL = "http://baidu.weather.com.cn/mhours/CITYCODE.shtml";

    // 未来15天天气预报
    private static final String WEATHER_15DAYS_URL = "http://baidu.weather.com.cn/mweather15d/CITYCODE.shtml";

    /**
     * 根据城市名称查询城市代码
     * 
     * @param cityName
     * @return
     */
    public String getCityCodeByCityName(String cityName) {
        String cityCode = null;
        try {
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("apikey", APIKEY);
            Map<String, String> params = new HashMap<String, String>();
            params.put("cityname", cityName);
            String json = HttpUitl.doGet(CITY_CODE_URL, headers, params);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
            JsonNode data = root.path("retData");
            cityCode = data.path("cityCode").asText();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityCode;
    }

    /**
     * 根据城市代码查询天气
     * 
     * @param cityCode
     * @return
     * @throws JsonMappingException
     */
    public Weather getWeatherByCityCode(String cityCode) throws JsonMappingException {
        Weather weather = null;
        try {
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("apikey", APIKEY);
            Map<String, String> params = new HashMap<String, String>();
            params.put("cityid", cityCode);
            String json = HttpUitl.doGet(WEATHER_URL, headers, params);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);// 忽略未知属性
            JsonNode root = mapper.readTree(json);
            JsonNode data = root.path("retData");
            weather = mapper.readValue(data, Weather.class);
            weather.setWebUrl(WEATHER_WEB_URL.replace("CITYCODE", cityCode));
            weather.setHoursUrl(WEATHER_HOURS_URL.replace("CITYCODE", cityCode));
            weather.setDaysUrl(WEATHER_15DAYS_URL.replace("CITYCODE", cityCode));
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }

    /**
     * 根据天气返回图片代码
     * 
     * @param weather
     * @return
     */
    public static String getImgByWeather(String weather) {
        String imgName = "00";
        if ("晴".equals(weather)) {
            imgName = "00";
        } else if ("多云".equals(weather)) {
            imgName = "01";
        } else if ("阴".equals(weather)) {
            imgName = "02";
        } else if ("阵雨".equals(weather)) {
            imgName = "03";
        } else if ("雷阵雨".equals(weather)) {
            imgName = "04";
        } else if ("雷阵雨伴有冰雹".equals(weather)) {
            imgName = "05";
        } else if ("雨夹雪".equals(weather)) {
            imgName = "06";
        } else if ("小雨".equals(weather)) {
            imgName = "07";
        } else if ("中雨".equals(weather)) {
            imgName = "08";
        } else if ("大雨".equals(weather)) {
            imgName = "09";
        } else if ("暴雨".equals(weather)) {
            imgName = "10";
        } else if ("大暴雨".equals(weather)) {
            imgName = "11";
        } else if ("特大暴雨".equals(weather)) {
            imgName = "12";
        } else if ("阵雪".equals(weather)) {
            imgName = "13";
        } else if ("小雪".equals(weather)) {
            imgName = "14";
        } else if ("中雪".equals(weather)) {
            imgName = "15";
        } else if ("大雪".equals(weather)) {
            imgName = "16";
        } else if ("暴雪".equals(weather)) {
            imgName = "17";
        } else if ("雾".equals(weather)) {
            imgName = "18";
        } else if ("冻雨".equals(weather)) {
            imgName = "19";
        } else if ("沙尘暴".equals(weather)) {
            imgName = "20";
        } else if ("小到中雨".equals(weather)) {
            imgName = "21";
        } else if ("中到大雨".equals(weather)) {
            imgName = "22";
        } else if ("大到暴雨".equals(weather)) {
            imgName = "23";
        } else if ("暴雨到大暴雨".equals(weather)) {
            imgName = "24";
        } else if ("大暴雨到特大暴雨".equals(weather)) {
            imgName = "25";
        } else if ("小到中雪".equals(weather)) {
            imgName = "26";
        } else if ("中到大雪".equals(weather)) {
            imgName = "27";
        } else if ("大到暴雪".equals(weather)) {
            imgName = "28";
        } else if ("浮尘".equals(weather)) {
            imgName = "29";
        } else if ("扬沙".equals(weather)) {
            imgName = "30";
        } else if ("强沙尘暴".equals(weather)) {
            imgName = "31";
        } else if ("霾".equals(weather)) {
            imgName = "53";
        }
        return imgName + ".png";
    }

    /**
     * 根据天气返回图片URL
     * 
     * @param weather
     * @return
     */
    public String getUrlByWeather(String weather) {
        String url = BASEPATH + "/resources/weather_ico";
        Date date = new Date();
        int hours = date.getHours();// 获取当前小时
        // 超过6点就算夜晚
        if (hours >= 18) {// 夜晚
            url += "/night";
        } else {// 白天
            url += "/day";
        }
        url += "/" + getImgByWeather(weather);
        return url;
    }

}
