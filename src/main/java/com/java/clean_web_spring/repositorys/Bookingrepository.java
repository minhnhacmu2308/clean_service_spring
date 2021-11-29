package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.Booking;
import com.java.clean_web_spring.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface Bookingrepository extends PagingAndSortingRepository<Booking, Integer> {
    Booking findFirstByOrderByIdDesc();
    List<Booking> findBookingByUserAndStatus(User user,int status);
}
