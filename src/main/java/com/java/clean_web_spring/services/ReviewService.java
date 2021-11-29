package com.java.clean_web_spring.services;

import com.java.clean_web_spring.domain.Review;
import com.java.clean_web_spring.domain.Shift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    List<Review> findAll();

}
