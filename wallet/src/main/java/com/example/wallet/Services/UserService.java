package com.example.wallet.Services;

import com.example.wallet.Dto.UserDto;
import com.example.wallet.Entities.User;

public interface UserService {
User findByUsername(String username);

 User save(UserDto userDto);
}
