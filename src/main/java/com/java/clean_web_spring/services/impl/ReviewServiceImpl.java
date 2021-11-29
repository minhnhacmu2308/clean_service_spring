package com.java.clean_web_spring.services.impl;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Review;
import com.java.clean_web_spring.domain.Shift;
import com.java.clean_web_spring.repositorys.ReviewRepository;
import com.java.clean_web_spring.repositorys.ShiftRepository;
import com.java.clean_web_spring.services.ReviewService;
import com.java.clean_web_spring.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findByCategoryItems(CategoryItems categoryItems) {
        return reviewRepository.findByCategoryItems(categoryItems);
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

}
