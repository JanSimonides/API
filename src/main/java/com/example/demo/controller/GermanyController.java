package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.model.entity.leagues.Germany;
import com.example.demo.model.entity.leagues.Italy;
import com.example.demo.service.GermanyService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GermanyController {
    @Autowired
    private GermanyService germanyService;
    @Autowired
    private UserService userService;


    @GetMapping("/germany")
    public ModelAndView show (@RequestParam("user") int id){
        ModelAndView modelAndView = new ModelAndView("bettingGermany.html");
        User user = userService.getUser(id);
        Germany germany = new Germany();
        modelAndView.addObject("germany", germany);
        modelAndView.addObject("user", user);
        modelAndView.getModelMap().addAttribute("germany",germany);
        modelAndView.getModelMap().addAttribute("user",user);

        return modelAndView;
    }

    @PostMapping("/germany")
    public ModelAndView bet (@RequestParam int id, @ModelAttribute(value="germany") Germany germany,RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("user",id);
        germany.setUserId(id);
        germanyService.save(germany);

        return new ModelAndView("redirect:" + "/england");
    }

    @GetMapping("/test")
    public ModelAndView test (){
        return new ModelAndView("test.html");
    }

    @GetMapping("/showGermany")
    public ModelAndView showGermany (@RequestParam(value = "user") int id, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("showGermany.html");

        User user = userService.getUser(id);
        Germany germany  = germanyService.find(id);
        modelAndView.getModelMap().addAttribute("germany",germany);
        modelAndView.getModelMap().addAttribute("user",user);
        redirectAttributes.addAttribute("user",id);
        return modelAndView;
    }

    @PostMapping("/showGermany")
    public ModelAndView show (@RequestParam int id, @ModelAttribute(value="germany") Germany germany, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("user",id);
        return new ModelAndView("redirect:" + "/showGermany");
    }
}
