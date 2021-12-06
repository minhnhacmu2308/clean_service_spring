package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.Role;
import com.java.clean_web_spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleById(int id);
}
