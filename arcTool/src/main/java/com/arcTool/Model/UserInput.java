package com.arcTool.Model;

import org.springframework.web.multipart.MultipartFile;

public class UserInput {
    private String FR;
    private MultipartFile file;

    public String getFR() {
        return FR;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFR(String FR) {
        this.FR = FR;
    }

    public void setFile(MultipartFile newFile) {
        this.file = newFile;
    }
}
