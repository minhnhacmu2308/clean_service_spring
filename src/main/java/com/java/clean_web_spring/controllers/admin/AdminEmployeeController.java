package com.java.clean_web_spring.controllers.admin;

import com.java.clean_web_spring.domain.Booking;
import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Role;
import com.java.clean_web_spring.domain.User;
import com.java.clean_web_spring.services.BookingService;
import com.java.clean_web_spring.services.impl.BookingServiceImpl;
import com.java.clean_web_spring.services.impl.UserServiceImpl;
import com.java.clean_web_spring.utils.EncrytedPasswordUtils;
import com.java.clean_web_spring.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminEmployeeController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    BookingServiceImpl bookingService;

    EncrytedPasswordUtils encrytedPasswordUtils = new EncrytedPasswordUtils();

    @GetMapping({ "/employee"})
    public ModelAndView index(String msg)
    {
        List<User> list = userService.listEmployee();
        ModelAndView mv = new ModelAndView("admin/employee");
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        return mv;
    }

    @PostMapping(value = "/employee-add")
    public ModelAndView add(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:employee");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String sdt = request.getParameter("sdt");
        String diachi = request.getParameter("diachi");
        String taikhoan = request.getParameter("taikhoan");
        String passwordMD5 = encrytedPasswordUtils.md5(request.getParameter("matkhau"));
        User user = new User();
        user.setAddress(diachi);
        user.setEmail(email);
        user.setFullName(fullname);
        user.setPhoneNumber(sdt);
        user.setUserName(taikhoan);
        user.setPassword(passwordMD5);
        user.setStatus(1);
        Role role = userService.findRoleById(2);
        user.setRole(role);
        userService.save(user);
        mv.addObject("msg","success");
        return mv;
    }

    @PostMapping(value = "/employee-update")
    public ModelAndView update(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:employee");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String sdt = request.getParameter("sdt");
        String diachi = request.getParameter("diachi");
        String taikhoan = request.getParameter("taikhoan");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        userService.update(diachi,email,fullname,sdt,taikhoan,idc);
        mv.addObject("msg","success");
        return mv;
    }

    @PostMapping(value = "/employee-delete")
    public ModelAndView delete(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:employee");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        List<Booking> listB = bookingService.getBookingEmp(idc);
        if(listB.size() > 0){
            mv.addObject("msg","error");
        }
        else {
            userService.delete(idc);
            mv.addObject("msg", "success");
        }
        return mv;
    }
}
