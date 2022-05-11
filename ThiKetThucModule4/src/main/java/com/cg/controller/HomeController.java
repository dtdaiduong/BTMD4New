package com.cg.controller;

import com.cg.model.City;
import com.cg.model.Country;
import com.cg.service.CityService;
import com.cg.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    CityService cityService;

    @Autowired
    CountryService countryService;

    @GetMapping
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView();
        List<City> cities = cityService.findAllNotDeleted();
        modelAndView.setViewName("index");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/info")
    public ModelAndView infoCity() {
        ModelAndView modelAndView = new ModelAndView();
//        List<City> cities = cityService.findAll();
//        modelAndView.setViewName("info");
//        modelAndView.addObject("cities",cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createCity() {
        ModelAndView modelAndView = new ModelAndView();
        List<Country> countries = countryService.findAll();
        modelAndView.setViewName("createCity");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("status", false);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateCity(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<City> opCity = cityService.findById(id);
        if (opCity.isPresent()) {
            List<Country> countries = countryService.findAll();
            modelAndView.setViewName("editCity");
            modelAndView.addObject("city", opCity.get());
            modelAndView.addObject("countries", countries);
            return modelAndView;
        } else {
            return new ModelAndView("editCity");
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView doDelete(@PathVariable Long id) {
        Optional<City> opCity = cityService.findById(id);
        if (opCity.isPresent()) {
            ModelAndView modelAndView = new ModelAndView();
            cityService.deleteCity(id);
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/error");
            return modelAndView;
        }
    }

    @GetMapping("/error")
    public ModelAndView error() {
        return new ModelAndView("error");
    }

    @PostMapping("/create")
    public ModelAndView doCreate(@Validated @ModelAttribute("city") City city, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("createCity");
        if (bindingResult.hasFieldErrors()) {
            List<Country> countries = countryService.findAll();
            modelAndView.addObject("city", city);
            modelAndView.addObject("countries", countries);
            return modelAndView;
        }
        cityService.save(city);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("update")
    public ModelAndView doUpdate(@Validated @ModelAttribute("city") City city, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("editCity");
        }
        cityService.save(city);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
