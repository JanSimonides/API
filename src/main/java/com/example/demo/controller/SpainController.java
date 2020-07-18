package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.model.entity.leagues.England;
import com.example.demo.model.entity.leagues.Italy;
import com.example.demo.model.entity.leagues.Spain;
import com.example.demo.service.EnglandService;
import com.example.demo.service.SpainService;
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
public class SpainController {

    @Autowired
    private UserService userService;
    @Autowired
    private SpainService spainService;

    @GetMapping("/spain")
    public ModelAndView show (@RequestParam("user") int id){
        ModelAndView modelAndView = new ModelAndView("bettingSpain.html");
        User user = userService.getUser(id);
        Spain spain = new Spain();
        //modelAndView.addObject("italy", italy);
        //modelAndView.addObject("user", user);
        modelAndView.getModelMap().addAttribute("spain",spain);
        modelAndView.getModelMap().addAttribute("user",user);

        return modelAndView;
    }

    @PostMapping("/spain")
    public ModelAndView bet (@RequestParam int id, @ModelAttribute(value="spain") Spain spain, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("user",id);
        spain.setUserId(id);
        spainService.save(spain);

        return new ModelAndView("redirect:" + "/result");
    }

    @GetMapping("/showSpain")
    public ModelAndView showSpain (@RequestParam(value = "user") int id, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("showSpain.html");

        User user = userService.getUser(id);
        Spain spain = spainService.find(id);
        modelAndView.getModelMap().addAttribute("spain",spain);
        modelAndView.getModelMap().addAttribute("user",user);
        redirectAttributes.addAttribute("user",id);
        return modelAndView;
    }

    @PostMapping("/showSpain")
    public ModelAndView show (@RequestParam int id, @ModelAttribute(value="spain") Spain spain, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("user",id);
        return new ModelAndView("redirect:" + "/showSpain");
    }
}
