package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.Items;
import com.java.clean_web_spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findUserByEmail(String email);

    User findUserByEmailAndPassword(String email,String password);

    @Query(value = "SELECT * from  user  WHERE email = ? and password = ? and role_id != 1 ",nativeQuery = true)
    User checkLoginAdmin(String email,String password);

    User findUserById(int id);

    @Query(value = "SELECT * from  user  WHERE role_id = 2 ",nativeQuery = true)
    List<User> listEmployee();

    @Query(value = "SELECT * from  user  WHERE role_id = 1 ",nativeQuery = true)
    List<User> listCustomer();

    User save(User user);

    @Modifying
    @Transactional
    @Query(value = "Update user SET address = ?, email = ? , full_name = ?, phone_number = ? , user_name = ? WHERE id = ?",nativeQuery = true)
    int update(String address, String email , String fullname, String phonenumber, String username, int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user WHERE id = ?",nativeQuery = true)
    int delete( int id);
}
