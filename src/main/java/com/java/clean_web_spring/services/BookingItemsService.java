package com.java.clean_web_spring.services;

import com.java.clean_web_spring.domain.BookingItems;
import com.java.clean_web_spring.domain.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingItemsService {
    BookingItems save(BookingItems bookingItems);

    List<BookingItems> findBookingItemsByItems(Items items);
}
