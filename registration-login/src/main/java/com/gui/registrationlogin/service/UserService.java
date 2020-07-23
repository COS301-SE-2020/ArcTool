package com.gui.registrationlogin.service;

import com.gui.registrationlogin.model.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveUser(User user);
}