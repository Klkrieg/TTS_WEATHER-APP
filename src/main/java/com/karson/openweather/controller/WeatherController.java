package com.karson.openweather.controller;

import com.karson.openweather.model.Request;
import com.karson.openweather.model.Response;
import com.karson.openweather.repository.RequestRepository;
import com.karson.openweather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class WeatherController {

  @Autowired
  private WeatherService weatherService;

  @Autowired
  private RequestRepository requestRepository;

  @GetMapping("/")
  public String getIndex(Model model){
    Request req = new Request();
    ArrayList<Request> reqList = (ArrayList<Request>) requestRepository.findAll();
    model.addAttribute("request", req);
    model.addAttribute("list", reqList);
    return "index";
  }

  @PostMapping("/")
  public String getZip(Request req, Model model){
    Response res = weatherService.getWeatherByZip(req.getZip());
    if(!res.getName().equals("error")){
      if(!requestRepository.existsById(req.getId())){
        requestRepository.save(new Request(req.getId(), req.getZip()));
      }
    }
    model.addAttribute("data", res);
    return "index";
  }
}
