package com.arcTool.Service;

import com.arcTool.UserModel.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveUser(User user);
}