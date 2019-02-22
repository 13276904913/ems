package com.hbc.ems.controller;

import com.hbc.ems.entity.User;
import com.hbc.ems.service.UserService;
import com.hbc.ems.util.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
@SpringBootApplication
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String username, String password) {
        boolean b = userService.login(username, password);
        if (b) {
            return "redirect:/employee/showAll";
        } else {
            return "login";
        }

    }

    @RequestMapping("/add")
    public String add(String code, HttpSession session, User user) {
        String sessionCode = (String) session.getAttribute("code");
        if (code.equals(sessionCode)) {
            userService.add(user);
            return "redirect:/login.jsp";
        } else {
            return "redirect:/regist.jsp";
        }

    }

    @RequestMapping("/captcha")
    public void captcha(HttpSession session, HttpServletResponse resp) throws Exception {
        String code = ValidateImageCodeUtils.getSecurityCode();
        session.setAttribute("code", code);
        BufferedImage image = ValidateImageCodeUtils.createImage(code);
        ServletOutputStream os = resp.getOutputStream();
        boolean b = ImageIO.write(image, "png", os);
        os.flush();
        os.close();

    }


}
