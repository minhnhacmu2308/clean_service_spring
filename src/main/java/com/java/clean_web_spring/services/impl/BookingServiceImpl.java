package com.java.clean_web_spring.services.impl;

import com.java.clean_web_spring.domain.Booking;
import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Review;
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

    @Override
    public List<Booking> findAll() {
        return bookingrepository.findAll();
    }

    @Override
    public int update(int status, int id) {
        return bookingrepository.update(status,id);
    }

    @Override
    public int accpect(int nhanvien, int id) {
        return bookingrepository.accpect(nhanvien,id);
    }

    @Override
    public List<Booking> findBookingByCategoryItems(CategoryItems categoryItems) {
        return bookingrepository.findBookingByCategoryItems(categoryItems);
    }

    @Override
    public List<Booking> getBookingEmp(int id) {
        return bookingrepository.getBookingEmp(id);
    }
}
