package com.java.clean_web_spring.services;

import com.java.clean_web_spring.domain.BookingItems;
import org.springframework.stereotype.Service;

@Service
public interface BookingItemsService {
    BookingItems save(BookingItems bookingItems);
}
