package com.gui.GUI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    public  String index_page="";

    @RequestMapping("/")
    public String index(){
        return  "Page not found";
    }
}
