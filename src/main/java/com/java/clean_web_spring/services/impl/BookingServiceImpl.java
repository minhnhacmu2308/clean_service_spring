package com.java.clean_web_spring.services.impl;

import com.java.clean_web_spring.domain.Booking;
import com.java.clean_web_spring.domain.User;
import com.java.clean_web_spring.repositorys.Bookingrepository;
import com.java.clean_web_spring.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    Bookingrepository bookingrepository;

    @Override
    public Booking save(Booking booking) {
        return bookingrepository.save(booking);
    }

    @Override
    public Booking getTopOneById() {
        return bookingrepository.findFirstByOrderByIdDesc();
    }

    @Override
    public List<Booking> getBookingById(User user,int status) {
        return bookingrepository.findBookingByUserAndStatus(user,status);
    }
}