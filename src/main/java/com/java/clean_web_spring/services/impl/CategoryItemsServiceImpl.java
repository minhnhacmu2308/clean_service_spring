package com.java.clean_web_spring.services.impl;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.repositorys.CategoryItemsRepository;
import com.java.clean_web_spring.services.CategoryItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryItemsServiceImpl implements CategoryItemsService {

    @Autowired
    CategoryItemsRepository categoryItemsRepository;

    @Override
    public Page<CategoryItems> findAll(Pageable pageable) {
        return categoryItemsRepository.findAll(pageable);
    }

    @Override
    public List<CategoryItems> findAll() {
        return categoryItemsRepository.findAll();
    }

    @Override
    public CategoryItems findCategoryItemsById(int id) {
        return categoryItemsRepository.findCategoryItemsById(id);
    }

    @Override
    public CategoryItems save(CategoryItems categoryItems) {
        return categoryItemsRepository.save(categoryItems);
    }

    @Override
    public int update(String name, String desciption , int cost,String image, int id) {
        return categoryItemsRepository.update(name,desciption,cost,image,id);
    }

    @Override
    public int delete(int id) {
        return categoryItemsRepository.delete(id);
    }
}
