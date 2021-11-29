package com.java.clean_web_spring.controllers.publics;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Review;
import com.java.clean_web_spring.services.CategoryItemsService;
import com.java.clean_web_spring.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("service")

public class CategoryItemController {

    @Autowired
    CategoryItemsService categoryItemsService;

    @Autowired
    ReviewService reviewService;

    @ModelAttribute
    public void addModel(Model model, @RequestParam("page") Optional<Integer> page)
    {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page.orElse(0), 6);
        Page<CategoryItems> categoryItemsList = categoryItemsService.findAll(pageable);
        List<CategoryItems> list = categoryItemsService.findAll();

        int numberPage = list.size() / 6;
        if (list.size() % 6 != 0){
            numberPage = numberPage +1;
        }
        List<CategoryItems> recruitmentSize = list.stream().limit(numberPage).collect(Collectors.toList());
        model.addAttribute("recruitmentList", recruitmentSize);
        model.addAttribute("list", categoryItemsList);
        model.addAttribute("size", list);
        model.addAttribute("numberPage",page.orElse(0).intValue());
    }

    @GetMapping({"/" , "/index"})
    public ModelAndView loadService()
    {
        ModelAndView mv = new ModelAndView("public/service");
        mv.addObject("activeHome",true);
        return mv;
    }

    @GetMapping({"/detail/{id}" })
    public ModelAndView getDetail(@PathVariable int id, HttpServletRequest request)
    {
        ModelAndView mv = new ModelAndView("public/detail");
        CategoryItems categoryItems = categoryItemsService.findCategoryItemsById(id);
        List<Review> reviewList = reviewService.findByCategoryItems(categoryItems);
        mv.addObject("reviewList",reviewList);
        mv.addObject("activeHome",true);
        mv.addObject("categoryItems",categoryItems);
        return mv;
    }
}
