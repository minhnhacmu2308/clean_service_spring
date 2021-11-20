package com.java.clean_web_spring.services;



import com.java.clean_web_spring.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User save(User user);

    User checkEmailExist(String email);

    User checkLogin(String email,String password);

    User getUserById(int id);
}
