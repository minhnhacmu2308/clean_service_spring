package com.java.clean_web_spring.controllers.publics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice
public class HomeController {

    @GetMapping({"/" , "/index"})
    public ModelAndView loadHomePage()
    {
        ModelAndView mv = new ModelAndView("public/home");
        mv.addObject("activeHome",true);
        return mv;
    }
}
