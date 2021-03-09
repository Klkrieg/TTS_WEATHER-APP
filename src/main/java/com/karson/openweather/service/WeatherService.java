package com.karson.openweather.service;

import com.karson.openweather.model.Request;
import com.karson.openweather.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

  @Value("${OPEN_WEATHER_API_KEY}")
  private String OPEN_WEATHER_API_KEY;


  public Response getWeatherByZip(String zip){
    String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zip + ",us&units=imperial&appid=" + OPEN_WEATHER_API_KEY;
    RestTemplate restTemplate = new RestTemplate();
    try{
      return restTemplate.getForObject(url, Response.class);
    }catch(HttpClientErrorException ex){
      Response response = new Response();
      response.setName("error");
      return response;
    }

  }
}
