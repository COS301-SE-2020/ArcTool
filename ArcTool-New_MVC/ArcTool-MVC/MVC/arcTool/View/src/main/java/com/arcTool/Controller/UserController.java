package com.arcTool.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.arcTool.UserModel.User;
import com.arcTool.Service.UserService;

@RestController
public class UserController {

 @Autowired
 private UserService userService;



  @RequestMapping(value = {"/login"}, method=RequestMethod.POST)
  public ModelAndView log_in() {
      ModelAndView model = new ModelAndView();
      //User user = new User();
      //model.addObject("user", user);
      model.setViewName("FR/functionalRequirements");
      return model;
  }

 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
 public ModelAndView signup() {
  ModelAndView model = new ModelAndView();
  User user = new User();
  model.addObject("user", user);
  model.setViewName("user/signup");
  
  return model;
 }

 @RequestMapping(value= {"/functionalRequirements"}, method=RequestMethod.GET)
 public ModelAndView fr() {
  ModelAndView model = new ModelAndView();
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  User user = userService.findUserByEmail(auth.getName());

  model.addObject("userName", user.getFirstname() + " " + user.getLastname());
  model.setViewName("FR/functionalRequirements");
  return model;
 }

 @RequestMapping(value = {"/history"}, method = RequestMethod.GET)
 public ModelAndView history(){
  ModelAndView modelAndView = new ModelAndView();
  User user = new User();
  modelAndView.addObject("user", user);
  modelAndView.setViewName("FR/history");
  return modelAndView;
 }
 
 @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
 public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
  ModelAndView model = new ModelAndView();
  User userExists = userService.findUserByEmail(user.getEmail());
  
  if(userExists != null) {
   bindingResult.rejectValue("email", "error.user", "This email already exists!");
  }
  if(bindingResult.hasErrors()) {
   model.setViewName("user/signup");
  } else {
   userService.saveUser(user);
   model.addObject("msg", "User has been registered successfully!");
   model.addObject("user", new User());
   model.setViewName("FR/functionalRequirements");
   System.out.println("**********************************New user account succcesfully created******************");
  }
  
  return model;
 }

}