package com.soecode.xfshxzs.handler;

import java.util.Map;

import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage.Item;
import com.soecode.wxtools.bean.outxmlbuilder.NewsBuilder;
import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.xfshxzs.po.weather.Weather;
import com.soecode.xfshxzs.po.weather.WeatherItem;
import com.soecode.xfshxzs.service.WeatherService;
import com.soecode.xfshxzs.util.EmojiUtil;

/**
 * 天气消息处理器
 */
public class WeatherMessageHandler implements WxMessageHandler {

    WeatherService weatherService = new WeatherService();

    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, WxService wxService)
            throws WxErrorException {
        String cityName = wxMessage.getContent().replace("天气", "").trim();
        try {
            String cityCode = weatherService.getCityCodeByCityName(cityName);
            Weather weather = weatherService.getWeatherByCityCode(cityCode);
            NewsBuilder builder = WxXmlOutMessage.NEWS();
            // 1.今天
            Item item1 = new Item();
            WeatherItem today = weather.getToday();
            item1.setTitle(cityName + " " + today.getType() + " 当前" + today.getCurTemp() + " 今日" + today.getLowtemp()
                    + "~" + today.getHightemp() + " " + today.getFengxiang() + " " + today.getFengli() + " PM"
                    + today.getAqi());
            item1.setPicUrl(weatherService.getUrlByWeather(today.getType()));
            item1.setUrl(weather.getWebUrl());
            builder.addArticle(item1);
            // 2.逐小时
            Item item2 = new Item();
            item2.setTitle("查看逐小时天气预报");
            item2.setUrl(weather.getHoursUrl());
            builder.addArticle(item2);
            // 3.明天
            Item item3 = new Item();
            WeatherItem tomorrow = weather.getForecast().get(0);
            item3.setTitle("【明天】" + tomorrow.getType() + " " + tomorrow.getLowtemp() + "~" + tomorrow.getHightemp()
                    + " " + tomorrow.getFengxiang() + " " + tomorrow.getFengli());
            item3.setPicUrl(weatherService.getUrlByWeather(tomorrow.getType()));
            builder.addArticle(item3);
            // 4.后天
            Item item4 = new Item();
            WeatherItem afterTomorrow = weather.getForecast().get(1);
            item4.setTitle("【后天】" + afterTomorrow.getType() + " " + afterTomorrow.getLowtemp() + "~"
                    + afterTomorrow.getHightemp() + " " + afterTomorrow.getFengxiang() + " "
                    + afterTomorrow.getFengli());
            item4.setPicUrl(weatherService.getUrlByWeather(afterTomorrow.getType()));
            builder.addArticle(item4);
            // 5.未来15天
            Item item5 = new Item();
            item5.setTitle("查看未来15天天气预报");
            item5.setUrl(weather.getDaysUrl());
            builder.addArticle(item5);
            // 6.昨天
            Item item6 = new Item();
            WeatherItem yesterday = weather.getHistory().get(weather.getHistory().size() - 1);
            item6.setTitle("【昨天】" + yesterday.getType() + " " + yesterday.getLowtemp() + "~" + yesterday.getHightemp()
                    + " " + yesterday.getFengxiang() + " " + yesterday.getFengli() + " PM" + today.getAqi());
            item6.setPicUrl(weatherService.getUrlByWeather(yesterday.getType()));
            builder.addArticle(item6);
            return builder.toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
        } catch (Exception e) {
            e.printStackTrace();
            String message = EmojiUtil.emoji(EmojiUtil.CROSS) + "查询不到\"" + cityName + "\"地区的天气信息！";
            return WxXmlOutMessage.TEXT().content(message).toUser(wxMessage.getFromUserName())
                    .fromUser(wxMessage.getToUserName()).build();
        }
    }

}
