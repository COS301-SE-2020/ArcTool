package com.arcTool.Model;

import org.springframework.web.multipart.MultipartFile;

public class UserInput {
    private String FR;
    private String path;

    public String getFR(){
        return FR;
    }

    public void setFR(String FR) {
        this.FR = FR;
    }

    public void setPath(String p){ this.path = p;}
    public String getPath(){ return path;}
}
