package com.gui.registrationlogin.controler;

import com.gui.registrationlogin.controller.UserController;
import com.gui.registrationlogin.model.Path;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserControllerTests {

    @Test
    void extract(){
        UserController userController = new UserController();
        Path path = new Path();
        String p= "";
        path.setFR("Bake");
        path.setPath(p);
        try{
            //Set p to a correct path for this test to pass and set it to a wrong path for it to fail
            assertEquals("File created", userController.extract(path, null));
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
}
