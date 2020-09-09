package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public ModelAndView register (){
        return new ModelAndView("registration.html");
    }

    @PostMapping("/registration")
        public ModelAndView registration (@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("passwordControl") String passwordControl, RedirectAttributes red){
        int result = userService.createUser(username,password,passwordControl);

        if (result == 0) {
            return new ModelAndView("redirect:" + "/");
        }
        else {
            return new ModelAndView("redirect:" + "/registrationError");
        }
    }

   @GetMapping("/registrationError")
    public ModelAndView registerE (){
        return new ModelAndView("registrationError.html");
    }

    @PostMapping("/registrationError")
    public ModelAndView registrationE (@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("passwordControl") String passwordControl,@RequestParam("team") String team, RedirectAttributes red){
        int result = userService.createUser(username,password,passwordControl);


        if (result == 0) {
            return new ModelAndView("redirect:" + "/");
        }
        else {
            return new ModelAndView("redirect:" + "/registrationError");
        }
    }


    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("index.html");
    }

    @PostMapping("/")
    public ModelAndView loginUser(@RequestParam("username") String username,@RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        int result = userService.loginUser(username,password);
        User user = userService.getUser(username);
        if (user !=null) {
        }
        if (result == 0){
            return new ModelAndView("redirect:" + "/");
        }
        else if (result == 1){
            redirectAttributes.addAttribute("user", user.getId());
            return new ModelAndView("redirect:" + "/main");
        }
        else {
            redirectAttributes.addAttribute("user", user.getId());
            return new ModelAndView("redirect:" + "/result");
        }
    }


    @GetMapping("/main")
    public ModelAndView main(@RequestParam("user") int id){
        ModelAndView modelAndView = new ModelAndView("main.html");
        User user = userService.getUser(id);
        modelAndView.addObject("user",user);
        modelAndView.getModelMap().addAttribute("user",user);

        return modelAndView;
    }


    @PostMapping("/main") ModelAndView bet (@ModelAttribute (value="user") User  user,@RequestParam int id, RedirectAttributes redirectAttributes){
        User userToSave = userService.getUser(id);
        userToSave.setTeam(user.getTeam());
        System.out.println("ID: "+userToSave.getPassword());

        userService.saveUser(userToSave);
        redirectAttributes.addAttribute("user",userToSave.getId());
        return new ModelAndView("redirect:" + "/italy");
    }

    /*@PostConstruct
    public void admin (){
        User admin = new User();
        admin.setPassword("qwe");
        admin.setUsername("admin");
        admin.setTeam("AC");

            userService.saveUser(admin);

    }*/

    @GetMapping("/showBet")
    public ModelAndView show(@RequestParam("user") int id, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("show.html");
        User user = userService.getUser(id);
        modelAndView.getModelMap().addAttribute("user",user);

        List<User> users = userService.findAll();
        System.out.println("\n Pocet: "+users.size());

        redirectAttributes.addAttribute("user",id);

        modelAndView.getModelMap().addAttribute("users",users);


        return modelAndView;
    }

    @PostMapping("/showBet")
    public ModelAndView showBet (@RequestParam("id") int id, RedirectAttributes redirectAttributes){
        User user = userService.getUser(id);

        redirectAttributes.addAttribute("user",id);
        return new ModelAndView("redirect:" + "/showBet");
    }




}
