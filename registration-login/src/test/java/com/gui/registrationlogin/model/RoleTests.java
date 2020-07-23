package com.gui.registrationlogin.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoleTests {

    @Test
    void getRole(){
        Role r =new Role();
        r.setRole("Admin");
        assertEquals("Admin", r.getRole()); //Pass
        //assertEquals("user", r.getRole());  //Fail
    }
}
