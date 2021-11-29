package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.Booking;
import com.java.clean_web_spring.domain.BookingItems;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookingItemsRepository extends PagingAndSortingRepository<BookingItems, Integer> {
}
