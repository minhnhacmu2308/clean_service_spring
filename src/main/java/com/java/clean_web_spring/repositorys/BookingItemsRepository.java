package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.Booking;
import com.java.clean_web_spring.domain.BookingItems;
import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookingItemsRepository extends PagingAndSortingRepository<BookingItems, Integer> {

    List<BookingItems> findBookingItemsByItems(Items items);

}
