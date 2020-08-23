package com.arcTool.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @RequestMapping(value= {"/"}, method= RequestMethod.GET)
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

    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("user/access_denied");
        return model;
    }
}
