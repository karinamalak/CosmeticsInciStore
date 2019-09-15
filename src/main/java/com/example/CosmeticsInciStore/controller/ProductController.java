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
import java.util.List;

import static com.example.CosmeticsInciStore.mapper.ProductMapper.toDTO;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String findAll(@RequestParam(required = false) Long id,
                          @RequestParam(required = false) String name,
                          Model model){

        List<Product> products = new ArrayList<>();
        if (id != null) {
            products.add(productService.getById(id));
        }
        else if (name != null) {
//            products.addAll(productService.findAllByName(name));
            products.add(productService.findByName(name));
        }
        else {
            products.addAll(productService.findAll());
        }
        model.addAttribute("products", products);
        return "product_list";
    }


    @RequestMapping(value = "/add_product", method = RequestMethod.GET)
    public String addProductView(Model model){
        model.addAttribute("productDto", new ProductDTO());
        return "add_product";
    }

    @PostMapping(value = "/products")
    public String createProduct(@Valid @ModelAttribute("productDto") ProductDTO productDTO, Model model){

        if(productDTO.getId() == null) {
            this.productService.createProduct(productDTO);
        } else {
            this.productService.updateProduct(productDTO);
        }
        model.addAttribute("products", this.productService.findAll());
        return "products";
    }

    @PostMapping(value = "/delete_product")
    public String deleteProduct(@RequestParam(required = true) Long id, Model model){
        this.productService.deleteProductById(id);
        model.addAttribute("products", this.productService.findAll());
        return "products";
    }

    @PostMapping(value = "/edit_product")
    public String editProduct(@RequestParam(required = true) Long id, Model model){
        model.addAttribute("productDto", toDTO(this.productService.getById(id)));
        return "add_product";
    }

    @PostMapping(value = "/user/shopping_cart")
    public String addToCart(@RequestParam(required = true) Long id, HttpSession session){
        if (session.getAttribute("shoppingCart") == null) {
            session.setAttribute("shoppingCart", new ArrayList<Product>());
        }
        List<Product> shoppingCart = (List<Product>) session.getAttribute("shoppingCart");
        Product productInDB = productService.getById(id);
        Product productToSession = new Product();
        productToSession.setId(productInDB.getId());
        productToSession.setName(productInDB.getName());
        productToSession.setCategory(productInDB.getCategory());
        productToSession.setPrice(productInDB.getPrice());
        shoppingCart.add(productToSession);
        return "redirect:/user/shopping_cart";
    }

}
