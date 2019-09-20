package com.example.CosmeticsInciStore.controller;

import com.example.CosmeticsInciStore.DTO.ProductDTO;
import com.example.CosmeticsInciStore.entity.Product;
import com.example.CosmeticsInciStore.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.example.CosmeticsInciStore.mapper.ProductMapper.toDTO;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/admin/products", method = RequestMethod.GET)
    public List<Product> findAll(Model model){
        model.addAttribute("products", productService.findAll());
            return this.productService.findAll();
    }

    @RequestMapping(value = "/admin/add_product", method = RequestMethod.GET)
    public String addProductView(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        return "admin/add_product";
    }

    @PostMapping(value = "/admin/add_product")
    public String createProduct(@Valid ProductDTO productDTO, Model model) {
        if (productDTO.getName() == null) {
            model.addAttribute("productDTO", new Product());
            this.productService.createProduct(productDTO);
        } else {
            this.productService.updateProduct(productDTO);
        }
        model.addAttribute("products", this.productService.findAll());
        return "admin/products";
    }


    @GetMapping("/")
    public String findAll(@RequestParam(required = false) Long id,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) String category,
                          Model model){

        List<Product> products = new ArrayList<>();
        if (id != null) {
            products.add(productService.getById(id));
        }
        else if (name != null) {
//            products.addAll(productService.findAllByName(name));
            products.add(productService.findByName(name));
        }
        else if (category != null) {
            products.addAll(productService.findAllByCategory(category));
        }
        else {
            products.addAll(productService.findAll());
        }
        model.addAttribute("products", products);
        return "product_list";
    }


    @PostMapping(value = "/user/shopping_cart")
    public String addToCart(@RequestParam(required = true) Long id, HttpSession session){
        if (session.getAttribute("shoppingCart") == null) {
            session.setAttribute("shoppingCart", new LinkedHashSet<Product>());
        }
        Set<Product> shoppingCart = (Set<Product>) session.getAttribute("shoppingCart");
        Product productInDB = productService.getById(id);
        Product productToSession = new Product();
        productToSession.setId(productInDB.getId());
        productToSession.setName(productInDB.getName());
        productToSession.setAmount(productInDB.getAmount());
        productToSession.setCategory(productInDB.getCategory());
        productToSession.setPrice(productInDB.getPrice());
        for (Product product:shoppingCart
             ) {
            if (product.getName().equals(productToSession.getName())) {
                //licznik dla kazdego elementu z listy shoppingcart
//shoppingCart.
            }
        }


        shoppingCart.add(productToSession);
        return "redirect:/user/shopping_cart";

    }

    @PostMapping(value = "/admin/delete_product")
    public String deleteProduct(@RequestParam(required = true) Long id, Model model){
        this.productService.deleteProductById(id);
        model.addAttribute("products", this.productService.findAll());
        return "admin/products";
    }

}
