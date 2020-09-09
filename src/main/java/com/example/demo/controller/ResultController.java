package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.model.entity.leagues.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Comparator;
import java.util.List;

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
        user.setEngland(englandService.find(id));
        user.setFrance(franceService.find(id));
        user.setSpain(spainService.find(id));

        userService.saveUser(user);
        redirectAttributes.addAttribute("user",id);

        List<User> users = userService.findAll();
        for (User i : users){

            int points =0;
            Italy italy = i.getItaly();
            Germany germany = i.getGermany();
            France france = i.getFrance();
            England england = i.getEngland();
            Spain spain = i.getSpain();

            points = italy.score() + germany.score()+ france.score()+ england.score()+spain.score();
            i.setPoints(points);
            System.out.println("Score: " +i.getUsername()+" "+points);
        }
        users.sort(Comparator.comparing(User::getPoints));

        for (int i= 0; i < users.size(); i++){
            System.out.println(i+1+". "+users.get(i).getUsername());
        }

        return modelAndView;
    }

    @PostMapping("/result")
        public ModelAndView back (@RequestParam int id,RedirectAttributes redirectAttributes){
        User user = userService.getUser(id);

        redirectAttributes.addAttribute("user",id);
        return new ModelAndView("redirect:" + "/result");
    }

}
