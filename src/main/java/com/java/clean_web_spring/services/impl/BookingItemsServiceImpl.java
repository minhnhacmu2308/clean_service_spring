package com.java.clean_web_spring.services.impl;

import com.java.clean_web_spring.domain.Booking;
import com.java.clean_web_spring.domain.BookingItems;
import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import com.java.clean_web_spring.repositorys.BookingItemsRepository;
import com.java.clean_web_spring.repositorys.Bookingrepository;
import com.java.clean_web_spring.services.BookingItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingItemsServiceImpl implements BookingItemsService {

    @Autowired
    BookingItemsRepository bookingItemsRepository;

    @Override
    public BookingItems save(BookingItems bookingItems) {
        return bookingItemsRepository.save(bookingItems);
    }

    @Override
    public List<BookingItems> findBookingItemsByItems(Items items) {
        return bookingItemsRepository.findBookingItemsByItems(items);
    }
}
