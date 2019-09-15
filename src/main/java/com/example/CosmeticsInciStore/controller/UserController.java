package com.example.CosmeticsInciStore.controller;


import com.example.CosmeticsInciStore.entity.Product;
import com.example.CosmeticsInciStore.entity.User;
import com.example.CosmeticsInciStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        //public String registration(Model model)
        //model.
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/admin_home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getSurname() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage", "This Page is available to Users with Admin Role");
        modelAndView.setViewName("admin/admin_home");
        return modelAndView;
    }

    @RequestMapping(value = "/user/user_home", method = RequestMethod.GET)
    public ModelAndView user() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("Name", user.getName());
        modelAndView.addObject("Surname", user.getSurname());
        modelAndView.addObject("Email", user.getEmail());
        //modelAndView.addObject("userMessage","This Page is available to Users with User Role");
        modelAndView.setViewName("user/user_home");
        return modelAndView;
    }

    @RequestMapping(value = "/user/shopping_cart", method = RequestMethod.GET)
    public String shoppingCart(HttpSession session, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (session.getAttribute("shoppingCart") == null) {
            session.setAttribute("shoppingCart", new ArrayList<Product>());
        }
        List<Product> products = (List<Product>) session.getAttribute("shoppingCart");
        model.addAttribute("products", products);

       return "User/shopping_cart";
    }
    @RequestMapping(value = "/admin/users_list", method = RequestMethod.GET)
    public List<User> findAll(Model model){
        model.addAttribute("users", userService.findAll());
        return this.userService.findAll();
    }
}

