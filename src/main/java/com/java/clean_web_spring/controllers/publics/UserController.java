package com.java.clean_web_spring.controllers.publics;

import com.java.clean_web_spring.Constants.CommonConstants;
import com.java.clean_web_spring.domain.User;
import com.java.clean_web_spring.services.UserService;
import com.java.clean_web_spring.utils.Middleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

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
}
