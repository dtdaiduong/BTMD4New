package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/create")
    public ModelAndView shoeCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer){
        customerService.insertWithStoredProcedure(customer);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer create success");
        return modelAndView;
    }

}
