package com.gui.registrationlogin.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PathTests {

    @Test
    void getFR(){
        Path path = new Path("Bake cake", "C://Downloads/files");
        assertEquals("Bake cake", path.getFR());    //Pass
        //assertEquals("cook", path.getFR());   //Fail
    }

    @Test
    void getPath(){
        Path path = new Path("Bake cake", "C://Downloads/files");
        assertEquals("C://Downloads/files", path.getPath());    //Pass
        //assertEquals("C://Downloads/Frame", path.getPath());  //Fail
    }
}
