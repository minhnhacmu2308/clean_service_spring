package com.java.clean_web_spring.utils;


import com.java.clean_web_spring.Constants.CommonConstants;
import com.java.clean_web_spring.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class Middleware {

    public  static boolean middleware( HttpServletRequest request){;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CommonConstants.SESSION_USER);
        if (Objects.nonNull(user)) {
            return true;
        } else {
            return false;
        }
    }

    public  static boolean middlewareAdmin( HttpServletRequest request){;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CommonConstants.SESSION_ADMIN);
        if (Objects.nonNull(user)) {
            return true;
        } else {
            return false;
        }
    }
}
