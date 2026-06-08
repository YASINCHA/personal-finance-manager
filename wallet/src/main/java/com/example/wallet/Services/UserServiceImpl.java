package com.example.wallet.Services;


import org.springframework.stereotype.Service;

import com.example.wallet.Dto.UserDto;
import com.example.wallet.Entities.User;
import com.example.wallet.Repositories.UserRepository;

@Service

public class UserServiceImpl implements UserService {




 private UserRepository userRepository;

 public UserServiceImpl(UserRepository userRepository) {
  super();
  this.userRepository = userRepository;
 }

 @Override
 public User findByUsername(String username) {
  return userRepository.findByUsername(username);
 }

 @Override
 public User save(UserDto userDto) {
  User user = new User(userDto.getUsername(),userDto.getPassword());
  return userRepository.save(user);
 }    
}
