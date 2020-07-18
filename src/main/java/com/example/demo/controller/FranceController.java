package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.model.entity.leagues.England;
import com.example.demo.model.entity.leagues.France;
import com.example.demo.model.entity.leagues.Italy;
import com.example.demo.service.EnglandService;
import com.example.demo.service.FranceService;
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
public class FranceController {

    @Autowired
    private UserService userService;
    @Autowired
    private FranceService franceService;

    @GetMapping("/france")
    public ModelAndView show (@RequestParam("user") int id){
        ModelAndView modelAndView = new ModelAndView("bettingFrance.html");
        User user = userService.getUser(id);
        France france = new France();
        //modelAndView.addObject("italy", italy);
        //modelAndView.addObject("user", user);
        modelAndView.getModelMap().addAttribute("france",france);
        modelAndView.getModelMap().addAttribute("user",user);

        return modelAndView;
    }

    @PostMapping("/france")
    public ModelAndView bet (@RequestParam int id, @ModelAttribute(value="france") France france, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("user",id);
        france.setUserId(id);
        franceService.save(france);

        return new ModelAndView("redirect:" + "/spain");
    }

    @GetMapping("/showFrance")
    public ModelAndView showFrance (@RequestParam(value = "user") int id, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("showFrance.html");

        User user = userService.getUser(id);
        France france = franceService.find(id);
        modelAndView.getModelMap().addAttribute("france", france);
        modelAndView.getModelMap().addAttribute("user",user);
        redirectAttributes.addAttribute("user",id);
        return modelAndView;
    }

    @PostMapping("/showFrance")
    public ModelAndView show (@RequestParam int id, @ModelAttribute(value="france") France france, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("user",id);
        return new ModelAndView("redirect:" + "/showFrance");
    }
}
