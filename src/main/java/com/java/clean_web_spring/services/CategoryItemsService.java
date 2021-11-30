package com.java.clean_web_spring.services;

import com.java.clean_web_spring.domain.CategoryItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryItemsService {

    Page<CategoryItems> findAll(Pageable pageable);

    List<CategoryItems> findAll();

    CategoryItems findCategoryItemsById(int id);

    CategoryItems save(CategoryItems categoryItems);

    int update(String name, String desciption , int cost, String image,int id);

    int delete(int id);
}
