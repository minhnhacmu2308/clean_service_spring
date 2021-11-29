package com.java.clean_web_spring.services;

import com.java.clean_web_spring.domain.Shift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShiftService {

    List<Shift> findAll();

    int update(int cost, int id);

    List<Shift> getAll();

    Shift findShiftById(int id);
}
