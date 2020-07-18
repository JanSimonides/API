package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.model.entity.leagues.England;
import com.example.demo.model.entity.leagues.Germany;
import com.example.demo.model.entity.leagues.Italy;
import com.example.demo.repository.EnglandRepository;
import com.example.demo.service.EnglandService;
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
public class EnglandController {

    @Autowired
    private UserService userService;
    @Autowired
    private EnglandService englandService;

    @GetMapping("/england")
    public ModelAndView show (@RequestParam("user") int id){
        ModelAndView modelAndView = new ModelAndView("bettingEngland.html");
        User user = userService.getUser(id);
        England england = new England();
        //modelAndView.addObject("italy", italy);
        //modelAndView.addObject("user", user);
        modelAndView.getModelMap().addAttribute("england",england);
        modelAndView.getModelMap().addAttribute("user",user);

        return modelAndView;
    }

    @PostMapping("/england")
    public ModelAndView bet (@RequestParam int id, @ModelAttribute(value="england") England england, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("user",id);
        england.setUserId(id);
        englandService.save(england);

        return new ModelAndView("redirect:" + "/france");
    }

    public England find (int id){
        return englandService.find(id);
    }

    @GetMapping("/showEngland")
    public ModelAndView showEngland (@RequestParam(value = "user") int id, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("showEngland.html");

        User user = userService.getUser(id);
        England england = englandService.find(id);
        modelAndView.getModelMap().addAttribute("england",england);
        modelAndView.getModelMap().addAttribute("user",user);
        redirectAttributes.addAttribute("user",id);
        return modelAndView;
    }

    @PostMapping("/showEngland")
    public ModelAndView show (@RequestParam int id, @ModelAttribute(value="england") England england, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("user",id);
        return new ModelAndView("redirect:" + "/showEngland");
    }
}
