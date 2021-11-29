package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.Booking;
import com.java.clean_web_spring.domain.Review;
import com.java.clean_web_spring.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface Bookingrepository extends PagingAndSortingRepository<Booking, Integer> {
    Booking findFirstByOrderByIdDesc();
    List<Booking> findBookingByUserAndStatus(User user,int status);
    List<Booking> findAll();

    @Modifying
    @Transactional
    @Query(value = "Update booking SET status = ? WHERE id = ?",nativeQuery = true)
    int update(int status, int id);
}
