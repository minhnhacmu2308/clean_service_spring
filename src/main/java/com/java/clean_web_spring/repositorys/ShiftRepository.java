package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.Items;
import com.java.clean_web_spring.domain.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {

    List<Shift> findAll();

    @Modifying
    @Transactional
    @Query(value = "Update shift SET price = ? WHERE id = ?",nativeQuery = true)
    int update(int cost, int id);

}
