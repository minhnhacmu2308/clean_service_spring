package com.java.clean_web_spring.services.impl;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import com.java.clean_web_spring.domain.Shift;
import com.java.clean_web_spring.repositorys.ItemsRepository;
import com.java.clean_web_spring.repositorys.ShiftRepository;
import com.java.clean_web_spring.services.ItemsService;
import com.java.clean_web_spring.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    ShiftRepository shiftRepository;

    @Override
    public List<Shift> findAll() {
        return shiftRepository.findAll();
    }


    @Override
    public int update(int cost, int id) {
        return shiftRepository.update(cost,id);
    }

}
