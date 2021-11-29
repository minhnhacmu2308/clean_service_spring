package com.java.clean_web_spring.services.impl;

import com.java.clean_web_spring.domain.BookingItems;
import com.java.clean_web_spring.repositorys.BookingItemsRepository;
import com.java.clean_web_spring.repositorys.Bookingrepository;
import com.java.clean_web_spring.services.BookingItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingItemsServiceImpl implements BookingItemsService {

    @Autowired
    BookingItemsRepository bookingItemsRepository;

    @Override
    public BookingItems save(BookingItems bookingItems) {
        return bookingItemsRepository.save(bookingItems);
    }
}
