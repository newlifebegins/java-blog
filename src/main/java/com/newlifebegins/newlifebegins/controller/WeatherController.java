package com.newlifebegins.newlifebegins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auth wangwei
 * @time 2019/12/6
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("getWeather")
    public String getWeather() {
        // https://api.thinkpage.cn/v3/weather/daily.json
        return restTemplate.getForObject("https://api.thinkpage.cn/v3/weather/daily.json?key=voayc2gazude6npo&location=太原&language=zh-Hans&start=0&days=1",String.class);
    }
}
