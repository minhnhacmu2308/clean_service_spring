package com.java.clean_web_spring.controllers.publics;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.services.CategoryItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    CategoryItemsService categoryItemsService;

    @ModelAttribute
    public void addModel(Model model,@RequestParam("page") Optional<Integer> page)
    {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        Page<CategoryItems> categoryItemsList = categoryItemsService.findAll(pageable);
        List<CategoryItems> list = categoryItemsService.findAll();

        int numberPage = list.size() / 5;
        if (list.size() % 5 != 0){
            numberPage = numberPage +1;
        }
        List<CategoryItems> recruitmentSize = list.stream().limit(numberPage).collect(Collectors.toList());
        model.addAttribute("recruitmentList", recruitmentSize);
        model.addAttribute("list", categoryItemsList);
        model.addAttribute("size", list);
        model.addAttribute("numberPage",page.orElse(0).intValue());
    }

    @GetMapping({"/" , "/index"})
    public ModelAndView loadHomePage()
    {
        ModelAndView mv = new ModelAndView("public/home");
        mv.addObject("activeHome",true);
        return mv;
    }
}
