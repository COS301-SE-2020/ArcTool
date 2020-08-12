package com.arcTool.Controller;

import javax.validation.Valid;

//import com.gui.registrationlogin.model.Path;
import com.arcTool.Model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.arcTool.UserModel.User;
import com.arcTool.Service.UserService;

 import org.jsoup.Jsoup;
 import org.jsoup.nodes.Document;

import java.awt.*;
import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.nio.file.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//@Controller
@RestController
public class UserController {

 @Autowired
 private UserService userService;
 
 @RequestMapping(value= {"/"}, method=RequestMethod.GET)
 public ModelAndView home() {
  ModelAndView model = new ModelAndView();
  
  model.setViewName("home/index");
  return model;
 }

 @RequestMapping(value= {"/login"}, method=RequestMethod.GET)
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

 @RequestMapping(value = {"/process"}, method = RequestMethod.POST)
 public String process(@RequestParam("comment") String comment){
  System.out.println("*******Processing*******");
  System.out.println("The comment is: " + comment);
  //System.out.println("The name of the zip file is: ");
  return "Processing";
 }
 /*public String Process(@ModelAttribute UserInput userInput, BindingResult bindingResult) throws IOException {
  System.out.println("****************************************Processing**********************");
  System.out.println("The User's FR is: "+ userInput.getFR());

  MultipartFile file = userInput.getFile();
 //Files.createDirectory(Path.of("/home/mxolisi/Documents/GitHub/ArcTool/WD" + StringUtils.cleanPath(file.getOriginalFilename())));

  return "The FR is : " + userInput.getFR();
 }*/

  //Extraction
//  //@GetMapping("/extract")
//  @RequestMapping(value = {"/extract"}, method = RequestMethod.POST)
//  public String extract(@ModelAttribute Path path, BindingResult bindingResult) throws IOException {
//         /*Scanner input = new Scanner(System.in);
//         System.out.print("Enter file path: ");
//         String path = input.nextLine();*/
//   System.out.println("Extracting*************");
//   System.out.println("FR: " + path.getFR());
//   System.out.println("Path: " + path.getPath());

//   String text = "";
//   FileWriter writer = new FileWriter("Functional_requirements.txt");
//   File files = new File(path.getPath());
//   int numFiles = files.list().length;

//   for (int a = 1; a < numFiles; a++) {
//    File input1 = new File(path.getPath()+"/index-"+a+".html");
//    Document doc = Jsoup.parse(input1, "UTF-8", "");
//    int i = 0;
//    while (true) {
//     try {
//      text = doc.getElementsByClass("block").get(i).text();
//      if (text.contains("FR")) {
//       writer.write(text+"\n");
//       System.out.print(text+".");

//       int index = 0;
//       while (true) {
//        try {
//         text = doc.getElementsByClass("typeNameLink").get(index).ownText();
//         writer.write("Class: "+text+"\n");
//         System.out.println("\t\t:: Class:"+text);
//         break;
//        } catch (Exception e) {
//         break;
//        }
//       }
//      }
//      i++;
//     } catch (Exception e) {
//      System.out.println(e.getMessage());
//      //return "File not created";
//      break;
//     }
//    }
//   }

//   writer.close();
//   return "File created";
//  }
 
 @RequestMapping(value= {"/functionalRequirements"}, method=RequestMethod.GET)
 public ModelAndView fr() {
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
  model.setViewName("user/access_denied");
  return model;
 }

 @RequestMapping(value = {"/login"}, method=RequestMethod.POST)
 public ModelAndView log_in() {
     ModelAndView model = new ModelAndView();
     //User user = new User();
     //model.addObject("user", user);
     model.setViewName("FR/functionalRequirements");
     return model;
 }

 ////////////////////////////////////////////////////
 //upload stuff///////////////
 /////////////////////////////////////////

 public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
 @RequestMapping("/")
 public String UploadPage(Model model) {
  return "FR/functionalRequirements";
 }
 @RequestMapping("/upload")
 public String upload(Model model,@RequestParam("files") MultipartFile[] files) {
  StringBuilder fileNames = new StringBuilder();
  for (MultipartFile file : files) {
   Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
   fileNames.append(file.getOriginalFilename()+" ");
   try {
    Files.write(fileNameAndPath, file.getBytes());
   } catch (IOException e) {
    e.printStackTrace();
   }
  }
  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
  return "results";
 }

}