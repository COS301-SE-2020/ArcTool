package com.gui.registrationlogin.controller;

import javax.validation.Valid;

import com.gui.registrationlogin.model.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gui.registrationlogin.model.User;
import com.gui.registrationlogin.service.UserService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

 @Autowired
 private UserService userService;
 
 @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
 public ModelAndView login() {
  ModelAndView model = new ModelAndView();
  
  model.setViewName("user/login");
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
   model.setViewName("FR/functionanRequirements");
  }
  
  return model;
 }

 //Extraction
 //@GetMapping("/extract")
 @RequestMapping(value = {"/extract"}, method = RequestMethod.POST)
 public String extract(@Valid Path path, BindingResult bindingResult) throws IOException {
        /*Scanner input = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = input.nextLine();*/
  System.out.println("Extracting*************");
  System.out.println("FR: " + path.getFR());
  System.out.println("Path: " + path.getPath());

  String text = "";
  FileWriter writer = new FileWriter("Functional_requirements.txt");
  File files = new File(path.getPath());
  int numFiles = files.list().length;

  for (int a = 1; a < numFiles; a++) {
   File input1 = new File(path.getPath()+"/index-"+a+".html");
   Document doc = Jsoup.parse(input1, "UTF-8", "");
   int i = 0;
   while (true) {
    try {
     text = doc.getElementsByClass("block").get(i).text();
     if (text.contains("FR")) {
      writer.write(text+"\n");
      System.out.print(text+".");

      int index = 0;
      while (true) {
       try {
        text = doc.getElementsByClass("typeNameLink").get(index).ownText();
        writer.write("Class: "+text+"\n");
        System.out.println("\t\t:: Class:"+text);
        break;
       } catch (Exception e) {
        break;
       }
      }
     }
     i++;
    } catch (Exception e) {
     //System.out.println(e.getMessage());
     return "File not created";
     //break;
    }
   }
  }

  writer.close();
  return "File created";
 }
 
 @RequestMapping(value= {"/FR/functionalRequirements"}, method=RequestMethod.GET)
 public ModelAndView home() {
  ModelAndView model = new ModelAndView();
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  User user = userService.findUserByEmail(auth.getName());
  
  model.addObject("userName", user.getFirstname() + " " + user.getLastname());
  model.setViewName("FR/functionalRequirements");
  return model;
 }
 
 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
 public ModelAndView accessDenied() {
  ModelAndView model = new ModelAndView();
  model.setViewName("errors/access_denied");
  return model;
 }

 @RequestMapping(value = {"/login"}, method=RequestMethod.POST)
 public ModelAndView log_in() {
     ModelAndView model = new ModelAndView();

     model.setViewName("FR/functionalRequirements");
     return model;
 }
 


}
