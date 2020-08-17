package com.arcTool.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class errorHandler implements ErrorController{
    private final static String PATH = "/error";

    @RequestMapping(PATH)
//    public String errorHandle(){
//        return "Error";
//    }

    @ResponseBody
    @Override
    public java.lang.String getErrorPath() {
        return "error";
    }

}

//public class errorHandler {
//}

