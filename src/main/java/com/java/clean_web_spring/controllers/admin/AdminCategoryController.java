package com.java.clean_web_spring.controllers.admin;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.repositorys.CategoryItemsRepository;
import com.java.clean_web_spring.services.impl.CategoryItemsServiceImpl;
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
public class AdminCategoryController {

    @Autowired
    CategoryItemsServiceImpl categoryItemsService;

    @GetMapping({ "/category"})
    public ModelAndView index(String msg)
    {
        List<CategoryItems> list = categoryItemsService.findAll();
        ModelAndView mv = new ModelAndView("admin/category");
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        return mv;
    }

    @PostMapping(value = "/category-add")
    public ModelAndView add(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:category");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String desciption = request.getParameter("description");
        CategoryItems categoryItems = new CategoryItems();
        categoryItems.setName(name);
        categoryItems.setPrice(price);
        categoryItems.setDescription(desciption);
        categoryItemsService.save(categoryItems);
        mv.addObject("msg","success");
        return mv;
    }
    @PostMapping(value = "/category-update")
    public ModelAndView update(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:category");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String desciption = request.getParameter("description");
        int id = Integer.parseInt(request.getParameter("id"));

        categoryItemsService.update(name,desciption,price,id);
        mv.addObject("msg","success");

        return mv;
    }
    @PostMapping(value = "/category-delete")
    public ModelAndView delete(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:category");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        categoryItemsService.delete(idc);
        mv.addObject("msg","success");
        return mv;
    }
}
