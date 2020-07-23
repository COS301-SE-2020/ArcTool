package com.gui.registrationlogin.model;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTests {

    @Test
    void  getFirstName(){
        User user = new User();
        user.setFirstname("Mxolisi");
        assertEquals("Mxolisi", user.getFirstname());
    }

    @Test
    void  getLastName(){
        User user = new User();
        user.setLastname("Mkanzi");
        assertEquals("Mkanzi", user.getLastname());
    }

    @Test
    void  getEmail(){
        User user = new User();
        user.setEmail("email@gmail.com");
        assertEquals("email@gmail.com", user.getEmail());
    }
    @Test
    void  getPassword(){
        User user = new User();
        user.setPassword("mypass");
        assertEquals("mypass", user.getPassword());
    }
}
