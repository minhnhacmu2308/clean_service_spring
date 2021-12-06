package com.java.clean_web_spring.controllers.admin;

import com.java.clean_web_spring.domain.Booking;
import com.java.clean_web_spring.domain.Review;
import com.java.clean_web_spring.services.impl.BookingServiceImpl;
import com.java.clean_web_spring.services.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminBookingController {

    @Autowired
    BookingServiceImpl bookingService;

    @GetMapping({ "/booking"})
    public ModelAndView index(String msg)
    {
        List<Booking> list = bookingService.findAll();
        ModelAndView mv = new ModelAndView("admin/booking");
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        return mv;
    }
    @PostMapping(value = "/booking-update")
    public ModelAndView update(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:booking");
        int status = Integer.parseInt(request.getParameter("status"));
        int id = Integer.parseInt(request.getParameter("id"));

        bookingService.update(status,id);
        mv.addObject("msg","success");

        return mv;
    }
    @PostMapping(value = "/booking-accpect")
    public ModelAndView accpect(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:booking");
        int nhanvien = Integer.parseInt(request.getParameter("nhanvien"));
        int id = Integer.parseInt(request.getParameter("id"));

        bookingService.accpect(nhanvien,id);
        mv.addObject("msg","success");

        return mv;
    }
}
