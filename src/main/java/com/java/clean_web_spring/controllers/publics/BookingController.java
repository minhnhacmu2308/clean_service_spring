package com.java.clean_web_spring.controllers.publics;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import com.java.clean_web_spring.services.CategoryItemsService;
import com.java.clean_web_spring.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("booking")
public class BookingController {

    @Autowired
    ItemsService itemsService;

    @Autowired
    CategoryItemsService categoryItemsService;


    @GetMapping("/index/{id}")
    public ModelAndView index(@PathVariable int id){
        ModelAndView mv = new ModelAndView();
        CategoryItems categoryItems = categoryItemsService.findCategoryItemsById(id);
        List<Items> itemsList = itemsService.getListItemsByCategory(categoryItems);
        return mv;
    }
}
