package com.java.clean_web_spring.controllers.publics;

import com.java.clean_web_spring.Constants.CommonConstants;
import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Review;
import com.java.clean_web_spring.domain.User;
import com.java.clean_web_spring.services.BookingItemsService;
import com.java.clean_web_spring.services.CategoryItemsService;
import com.java.clean_web_spring.services.ReviewService;
import com.java.clean_web_spring.services.UserService;
import com.java.clean_web_spring.utils.Middleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    CategoryItemsService categoryItemsService;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable int id, HttpServletRequest request){

        ModelAndView mv = new ModelAndView();
        boolean auth = Middleware.middleware(request);

        if (auth) {
            User userInformation = userService.getUserById(id);
            mv = new ModelAndView("public/profile");
            mv.addObject("userInformation",userInformation);
        } else {
            mv = new ModelAndView("redirect:/user/login");
        }
        return mv;
    }

    @PostMapping("/update-profile")
    public ModelAndView updateProfile(@ModelAttribute("user") User user, RedirectAttributes rd){
        User userCheck = userService.checkEmailExist(user.getEmail());
        user.setId(userCheck.getId());
        user.setPassword(userCheck.getPassword());
        user.setStatus(userCheck.getStatus());
        String url = "redirect:info/" + userCheck.getId();
        userService.save(user);
        rd.addFlashAttribute(CommonConstants.SUCCESS,
                messageSource.getMessage("update_success", null, Locale.getDefault()));
        ModelAndView mv = new ModelAndView(url);
        return mv;
    }

    @PostMapping("/review/{id}")
    public ModelAndView review(@PathVariable int id ,HttpServletRequest request,RedirectAttributes rd){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CommonConstants.SESSION_USER);
        CategoryItems categoryItems = categoryItemsService.findCategoryItemsById(id);
        String comment = request.getParameter("comment");
        Review review = new Review();
        review.setUser(user);
        review.setCategoryItems(categoryItems);
        review.setComment(comment);
        review.setCreatedAt(java.time.LocalDate.now().toString());
        reviewService.save(review);
        String url = "redirect:/booking/list/1/" + user.getId();
        ModelAndView mv = new ModelAndView(url);
        rd.addFlashAttribute(CommonConstants.SUCCESS,
                messageSource.getMessage("review_success", null, Locale.getDefault()));
        return mv;
    }
}
