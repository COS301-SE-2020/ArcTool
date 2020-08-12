package com.arcTool.Model;

import java.util.Set;

public class User {

    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private int active;

 public  User(String fn, String ln, String e, String p){
  this.firstname = fn;
  this.lastname = ln;
  this.email= e;
  this.password = p;
 }
 public  User(){}
 public int getId() {
  return id;
 }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

}
