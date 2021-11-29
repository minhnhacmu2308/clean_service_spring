package com.java.clean_web_spring.controllers.admin;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.User;
import com.java.clean_web_spring.services.impl.CategoryItemsServiceImpl;
import com.java.clean_web_spring.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminHomeController {

    @Autowired
    CategoryItemsServiceImpl categoryItemsService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping({"/" , "/index"})
    public ModelAndView loadHomePage()
    {
        ModelAndView mv = new ModelAndView("admin/home");
        List<CategoryItems> listC = categoryItemsService.findAll();
        List<User> listU = userService.getAll();
        int countC = listC.size();
        int countU = listU.size();
        mv.addObject("countC",countC);
        mv.addObject("countU",countU);
        return mv;
    }
}
