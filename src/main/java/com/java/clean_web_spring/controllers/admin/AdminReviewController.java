package com.java.clean_web_spring.controllers.admin;

import com.java.clean_web_spring.domain.Review;
import com.java.clean_web_spring.domain.Shift;
import com.java.clean_web_spring.services.impl.ReviewServiceImpl;
import com.java.clean_web_spring.services.impl.ShiftServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminReviewController {

    @Autowired
    ReviewServiceImpl reviewService;

    @GetMapping({ "/review"})
    public ModelAndView index(String msg)
    {
        List<Review> list = reviewService.findAll();
        ModelAndView mv = new ModelAndView("admin/review");
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        return mv;
    }
}
