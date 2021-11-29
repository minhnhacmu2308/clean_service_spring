package com.java.clean_web_spring.services;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemsService {
    List<Items> getListItemsByCategory(CategoryItems categoryItems);

    List<Items> findAll();

    Items save(Items items);

    int update(String name, int ct_id , int cost, int id);

    int delete(int id);
}
