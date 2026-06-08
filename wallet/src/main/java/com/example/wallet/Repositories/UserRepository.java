package com.example.wallet.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wallet.Dto.UserDto;
import com.example.wallet.Entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User save(UserDto userDto);
}
