package com.loginManagement.controller;

import com.loginManagement.model.Login;
import com.loginManagement.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RestController {

    @Autowired
    Service service;


    @GetMapping({"/","/LoginPage"})
    public String loginPage(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("login", new Login());
        model.addAttribute("message", message);

        return "LoginPage";
    }

    @PostMapping("/loginEvent")
    public String loginEvent(@ModelAttribute Login login, ModelMap model, RedirectAttributes redirectAttributes) {
        final String uri = "http://localhost:8091/ViewEvents";
        if (service.loginEvent(login)) {
            return "redirect:"+uri;
        }
        else {
            model.put("errorMsg", "Invalid Username or Password");
            return "LoginPage";

        }
    }

}
