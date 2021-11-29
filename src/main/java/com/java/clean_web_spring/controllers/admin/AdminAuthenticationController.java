package com.java.clean_web_spring.controllers.admin;

import com.java.clean_web_spring.Constants.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("admin")
public class AdminAuthenticationController {

    @Autowired
    MessageSource messageSource;

    @GetMapping({"/login"})
    public ModelAndView loadHomePage()
    {
        ModelAndView mv = new ModelAndView("admin/login");
        return mv;
    }
    @PostMapping({"/login"})
    public ModelAndView login(RedirectAttributes rd, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("admin/login");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        if (email.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("123456789")) {
            rd.addFlashAttribute(CommonConstants.MSG_REGISTER_SUCCESS,
                    messageSource.getMessage("login_success", null, Locale.getDefault()));
            mv = new ModelAndView("redirect:/admin/index");
        } else {
            mv.addObject("error","fail");
        }
        return mv;
    }
    @GetMapping(value = "logout")
    public ModelAndView getLogout(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:/admin/login");
        HttpSession session = request.getSession(false);
        session.invalidate();
        return mv;
    }
}
