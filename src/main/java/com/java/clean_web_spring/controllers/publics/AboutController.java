package com.java.clean_web_spring.controllers.publics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("about")
public class AboutController {
    @GetMapping({"/" , "/index"})
    public ModelAndView loadAbout()
    {
        ModelAndView mv = new ModelAndView("public/about");
        mv.addObject("activeHome",true);
        return mv;
    }
}
