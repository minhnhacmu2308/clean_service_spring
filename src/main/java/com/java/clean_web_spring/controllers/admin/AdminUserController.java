package com.java.clean_web_spring.controllers.admin;

import com.java.clean_web_spring.domain.Shift;
import com.java.clean_web_spring.domain.User;
import com.java.clean_web_spring.services.impl.ShiftServiceImpl;
import com.java.clean_web_spring.services.impl.UserServiceImpl;
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
public class AdminUserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping({ "/user"})
    public ModelAndView index(String msg)
    {
        List<User> list = userService.getAll();
        ModelAndView mv = new ModelAndView("admin/user");
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        return mv;
    }
}
