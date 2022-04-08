package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerCurrencyConversion {
    @GetMapping("/convert")
    public String conversion(@RequestParam double usd, Model model){
        double vnd = usd * 23000;
        model.addAttribute("usd", usd);
        model.addAttribute("vnd",vnd);
        return "result";
    }
}
