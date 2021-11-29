package com.java.clean_web_spring.controllers.admin;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import com.java.clean_web_spring.services.impl.CategoryItemsServiceImpl;
import com.java.clean_web_spring.services.impl.ItemsServiceImpl;
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
public class AdminItemController {

    @Autowired
    ItemsServiceImpl itemsService;

    @Autowired
    CategoryItemsServiceImpl categoryItemsService;

    @GetMapping({ "/item"})
    public ModelAndView index(String msg)
    {
        List<Items> list = itemsService.findAll();
        List<CategoryItems> listct = categoryItemsService.findAll();
        ModelAndView mv = new ModelAndView("admin/item");
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        mv.addObject("listct",listct);
        return mv;
    }

    @PostMapping(value = "/item-add")
    public ModelAndView add(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:item");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int ct_id = Integer.parseInt(request.getParameter("ct_id"));
        Items items = new Items();
        items.setName(name);
        items.setPrice(price);
        CategoryItems categoryItems = categoryItemsService.findCategoryItemsById(ct_id);
        items.setCategoryItems(categoryItems);
        itemsService.save(items);
        mv.addObject("msg","success");
        return mv;
    }
    @PostMapping(value = "/item-update")
    public ModelAndView update(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:item");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int ct_id = Integer.parseInt(request.getParameter("ct_id"));
        int id = Integer.parseInt(request.getParameter("id"));

        itemsService.update(name,ct_id,price,id);
        mv.addObject("msg","success");

        return mv;
    }
    @PostMapping(value = "/item-delete")
    public ModelAndView delete(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:item");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        itemsService.delete(idc);
        mv.addObject("msg","success");
        return mv;
    }
}
