package com.abb.WeatherApp.controller;

import com.abb.WeatherApp.dto.Root;
import com.abb.WeatherApp.dto.WeatherForecast;
import com.abb.WeatherApp.dto.WeatherResponse;
import com.abb.WeatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")

@CrossOrigin
public class WeatherController {
    @Autowired
    private  WeatherService service;

    @GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city)
    {
      return service.test();

   }

    @GetMapping("/my/{city}")
    public WeatherResponse getWeather(@PathVariable String city)
    {
        return service.getData(city);

    }

    @GetMapping("/forecast")
    public WeatherForecast getForecast(@RequestParam String city, @RequestParam int days)
    {
        return service.getForecast(city,days);
    }
}
