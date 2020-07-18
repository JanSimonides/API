package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.model.entity.leagues.England;
import com.example.demo.model.entity.leagues.Italy;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {
    @Autowired
    private UserService userService;

    @Autowired
    private FranceService franceService;

    @Autowired
    private SpainService spainService;

    @Autowired
    private EnglandService englandService;

    @Autowired
    private ItalyService italyService;

    @Autowired
    private GermanyService germanyService;

    @GetMapping("/result")
    public ModelAndView main(@RequestParam("user") int id, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("test.html");
        User user = userService.getUser(id);
        modelAndView.addObject("user",user);
        modelAndView.getModelMap().addAttribute("user",user);

        user.setItaly(italyService.find(id));
        user.setGermany(germanyService.find(id));

        userService.saveUser(user);
        redirectAttributes.addAttribute("user",id);
        return modelAndView;
    }

    @PostMapping("/result")
        public ModelAndView back (@RequestParam int id,RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("user",id);
        return new ModelAndView("redirect:" + "/result");
    }



}
