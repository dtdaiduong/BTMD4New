package com.cg.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ControllerDictionary {
    private Map<String,String> dictionary = new HashMap<>();

    public ControllerDictionary(){
        dictionary.put("Hello","Xin chao");
        dictionary.put("GoodBye","Tam biet");
    }

    @RequestMapping("/dictionary")
    public ModelAndView transfer(){
        ModelAndView modelAndView = new ModelAndView("WEB-INF/views/dictionary.jsp");
        return modelAndView;
    }

    @RequestMapping("/result")
    public ModelAndView result(@RequestParam String search){
        ModelAndView modelAndView = new ModelAndView("WEB-INF/views/result.jsp");
        String result = dictionary.get(search);
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
