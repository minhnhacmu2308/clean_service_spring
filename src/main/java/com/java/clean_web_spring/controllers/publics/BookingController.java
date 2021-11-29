package com.java.clean_web_spring.controllers.publics;

import com.java.clean_web_spring.Constants.CommonConstants;
import com.java.clean_web_spring.domain.*;
import com.java.clean_web_spring.services.*;
import com.java.clean_web_spring.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.java.clean_web_spring.utils.Middleware.middleware;

@Controller
@RequestMapping("booking")
public class BookingController {

    @Autowired
    ItemsService itemsService;

    @Autowired
    CategoryItemsService categoryItemsService;

    @Autowired
    ShiftService shiftService;

    @Autowired
    BookingService bookingService;

    @Autowired
    BookingItemsService bookingItemsService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    UserService userService;


    @GetMapping("/index/{id}")
    public ModelAndView index(@PathVariable int id, HttpServletRequest request){
        boolean auth = middleware(request);
        ModelAndView mv = new ModelAndView();
        if (auth) {
            mv = new ModelAndView("public/booking");
            CategoryItems categoryItems = categoryItemsService.findCategoryItemsById(id);
            List<Items> itemsList = itemsService.getListItemsByCategory(categoryItems);
            List<Shift> shiftList = shiftService.getAll();
            mv.addObject("categoryItems",categoryItems);
            mv.addObject("shiftList",shiftList);
            mv.addObject("itemsList",itemsList);
        } else {
            mv = new ModelAndView("public/login");
        }
        return mv;
    }

    @GetMapping(value = "/get-sum")
    public void getSum(HttpServletRequest request, HttpServletResponse response){
        String idShift = request.getParameter("idShift");
        String idItems = request.getParameter("idItems");
        String idCategoryItems = request.getParameter("idCategoryItems");
        CategoryItems categoryItems = categoryItemsService.findCategoryItemsById(Integer.parseInt(idCategoryItems));
        List<Integer> arrIdItems = new ArrayList<Integer>();
        if (idItems != null){
            arrIdItems = StringUtils.convertStringArray(idItems);
        }
        Shift shift = shiftService.findShiftById(Integer.parseInt(idShift));
        System.out.println(arrIdItems);
        Items items = null;
        int sum = 0;
        if (arrIdItems.size() == 0 ) {
            sum += categoryItems.getPrice()+shift.getPrice();
        } else {
            arrIdItems = StringUtils.convertStringArray(idItems);
            int sumItems = 0;
            for (int i = 0; i < arrIdItems.size(); i++) {
                items = itemsService.findItemsById(arrIdItems.get(i));
                sumItems += items.getPrice();
            }
            sum += categoryItems.getPrice() + sumItems+shift.getPrice();
        }
        try {
            PrintWriter pw = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            pw.println( sum );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @PostMapping("/add/{id}")
    public ModelAndView add(@PathVariable int id, @RequestParam(value = "items[]") List<String> arrId,
                            @ModelAttribute("Booking") Booking booking,HttpServletRequest request ,
                            RedirectAttributes rd){
        String url = "redirect:/booking/index/"+id;
        ModelAndView mv = new ModelAndView(url);
        int amount = 0;
        int sumItems = 0;
        Items items = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CommonConstants.SESSION_USER);
        CategoryItems categoryItems = categoryItemsService.findCategoryItemsById(id);
        booking.setUser(user);
        booking.setCategoryItems(categoryItems);
        System.out.println(arrId);
        if (arrId.size() != 0){
            for (int i = 0; i < arrId.size(); i++) {
                items = itemsService.findItemsById(Integer.parseInt(arrId.get(i)));
                sumItems += items.getPrice();
            }
            amount += sumItems + categoryItems.getPrice() + booking.getShift().getPrice();
        } else {
            amount += categoryItems.getPrice() + booking.getShift().getPrice();
        }
        System.out.println(amount);
        booking.setAmount(amount);
        booking.setCreatedAt(java.time.LocalDate.now().toString());
        booking.setStatus(0);
        bookingService.save(booking);
        Booking checkBooking = bookingService.getTopOneById();;
        for (int i = 0; i < arrId.size(); i++) {
            items = itemsService.findItemsById(Integer.parseInt(arrId.get(i)));
            BookingItems bookingItems = new BookingItems();
            bookingItems.setItems(items);
            bookingItems.setBooking(checkBooking);
            bookingItemsService.save(bookingItems);
        }
        rd.addFlashAttribute(CommonConstants.SUCCESS,
                messageSource.getMessage("booking_success", null, Locale.getDefault()));
        return mv;
    }

    @GetMapping("/list/{status}/{userId}")
    public ModelAndView listBooking(@PathVariable int status,@PathVariable int userId){
        ModelAndView mv = new ModelAndView();
        User user = userService.getUserById(userId);
        List<Booking> bookingList = bookingService.getBookingById(user,status);
        mv.addObject("bookingList",bookingList);
        return mv;
    }


}
