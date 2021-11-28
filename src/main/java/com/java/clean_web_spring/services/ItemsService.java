package com.java.clean_web_spring.services;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemsService {
    List<Items> getListItemsByCategory(CategoryItems categoryItems);
}
