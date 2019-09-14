package com.example.CosmeticsInciStore.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

    @RequestMapping(value="/", method = RequestMethod.GET) //oblsuguje tylko GET
    public String showHelloPage( ModelMap model){
        return "hello";
    }



}
