package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.model.entity.leagues.Italy;
import com.example.demo.service.ItalyService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class ItalyController {
    @Autowired
    private ItalyService italyService;

    @Autowired
    private UserService userService;

    @GetMapping("/italy")
    public ModelAndView show (@RequestParam("user") int id){
        ModelAndView modelAndView = new ModelAndView("bettingItaly.html");
        User user = userService.getUser(id);
        Italy italy = new Italy();
        //modelAndView.addObject("italy", italy);
        //modelAndView.addObject("user", user);
        modelAndView.getModelMap().addAttribute("italy",italy);
        modelAndView.getModelMap().addAttribute("user",user);

        return modelAndView;
    }

    @PostMapping("/italy")
    public ModelAndView bet (@RequestParam int id, @ModelAttribute(value="italy") Italy italy, RedirectAttributes redirectAttributes){
        italy.setUserId(id);
        italyService.save(italy);
        redirectAttributes.addAttribute("user",id);
        return new ModelAndView("redirect:" + "/germany");
    }


    @GetMapping("/showItaly")
    public ModelAndView showItaly (@RequestParam(value = "user") int id, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("showItaly.html");

        User user = userService.getUser(id);
        Italy italy = italyService.find(id);
        modelAndView.getModelMap().addAttribute("italy",italy);
        modelAndView.getModelMap().addAttribute("user",user);
        redirectAttributes.addAttribute("user",id);
        return modelAndView;
    }

    @PostMapping("/showItaly")
    public ModelAndView show (@RequestParam int id, @ModelAttribute(value="italy") Italy italy, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("user",id);
        return new ModelAndView("redirect:" + "/showItaly");
    }

}
