package com.java.clean_web_spring.services.impl;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import com.java.clean_web_spring.repositorys.ItemsRepository;
import com.java.clean_web_spring.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public List<Items> getListItemsByCategory(CategoryItems categoryItems) {
        return itemsRepository.findItemsByCategoryItems(categoryItems);
    }

    @Override
    public List<Items> findAll() {
        return itemsRepository.findAll();
    }

    @Override
    public Items save(Items items) {
        return itemsRepository.save(items);
    }

    @Override
    public int update(String name, int ct_id , int cost, int id) {
        return itemsRepository.update(name,ct_id,cost,id);
    }

    @Override
    public int delete(int id) {
        return itemsRepository.delete(id);
    }
}
