package com.java.clean_web_spring.controllers.admin;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import com.java.clean_web_spring.domain.Shift;
import com.java.clean_web_spring.services.ShiftService;
import com.java.clean_web_spring.services.impl.ItemsServiceImpl;
import com.java.clean_web_spring.services.impl.ShiftServiceImpl;
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
public class AdminShiftController {

    @Autowired
    ShiftServiceImpl shiftService;

    @GetMapping({ "/shift"})
    public ModelAndView index(String msg)
    {
        List<Shift> list = shiftService.findAll();
        ModelAndView mv = new ModelAndView("admin/shift");
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        return mv;
    }

    @PostMapping(value = "/shift-update")
    public ModelAndView update(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:shift");
        int price = Integer.parseInt(request.getParameter("price"));
        int id = Integer.parseInt(request.getParameter("id"));

        shiftService.update(price,id);
        mv.addObject("msg","success");

        return mv;
    }
}
