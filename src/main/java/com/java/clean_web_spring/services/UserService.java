package com.java.clean_web_spring.services;



import com.java.clean_web_spring.domain.Role;
import com.java.clean_web_spring.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User save(User user);

    User checkEmailExist(String email);

    User checkLogin(String email,String password);

    User getUserById(int id);

    User checkLoginAdmin(String email,String password);

    List<User> listEmployee();

    List<User> listCustomer();

    Role findRoleById(int id);

    int delete(int id);

    int update(String address, String email , String fullname, String phonenumber, String username, int id);
}
