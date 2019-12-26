package com.adalitek.mph.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.adalitek.mph.model.user;
import com.adalitek.mph.service.userService;



public class userController {
	
	@Autowired
    private userService userService;

	@RequestMapping(value={"/", "/userLogin"}, method = RequestMethod.GET)
    public ModelAndView userLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userLogin");
        return modelAndView;
    }


    @RequestMapping(value="/userRegister", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        user user = new user();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("Register");
        return modelAndView;
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid user user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        user userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("userRegister");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new user());
            modelAndView.setViewName("userRegister");

        }
        return modelAndView;
    }
    
    @RequestMapping(value="/admin/adminHome", method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","This Page is available to Users with Admin Role");
        modelAndView.setViewName("admin/adminHome");
        return modelAndView;
    }

   

}


