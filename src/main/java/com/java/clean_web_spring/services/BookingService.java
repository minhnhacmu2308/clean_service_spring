package com.java.clean_web_spring.services;

import com.java.clean_web_spring.domain.Booking;
import com.java.clean_web_spring.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    Booking save(Booking booking);

    Booking getTopOneById();

    List<Booking> getBookingById(User user,int status);
}