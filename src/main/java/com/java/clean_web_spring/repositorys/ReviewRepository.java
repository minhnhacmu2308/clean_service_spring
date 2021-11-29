package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.Review;
import com.java.clean_web_spring.domain.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findAll();

}
