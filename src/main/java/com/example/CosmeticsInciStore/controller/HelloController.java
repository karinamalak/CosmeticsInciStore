package com.example.CosmeticsInciStore.controller;


import com.example.CosmeticsInciStore.entity.Product;
import com.example.CosmeticsInciStore.service.ProductService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HelloController {

    @RequestMapping(value="/", method = RequestMethod.GET) //oblsuguje tylko GET
    public String showHelloPage( ModelMap model){
        return "hello";
    }



}
