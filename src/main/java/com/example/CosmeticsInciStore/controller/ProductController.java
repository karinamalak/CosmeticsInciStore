package com.example.CosmeticsInciStore.controller;

import com.example.CosmeticsInciStore.DTO.ProductDTO;
import com.example.CosmeticsInciStore.entity.Product;
import com.example.CosmeticsInciStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public List<Product> findAllProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return this.productService.findAll();
    }

    @RequestMapping(value = "/admin/add_product", method = RequestMethod.GET)
    public String addProductView(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        return "admin/add_product";
    }


    @PostMapping(value = "/admin/add_product")
    public String createProduct(@Valid ProductDTO productDTO, Model model){

        if(productDTO.getName() == null) {
            model.addAttribute("productDTO", new Product());
            this.productService.createProduct(productDTO);
        } else {
            this.productService.updateProduct(productDTO);
        }
        model.addAttribute("products", this.productService.findAll());
        return "admin/products";
    }


    @PostMapping(value = "/admin/delete_product")
    public String deleteProduct(@RequestParam(required = true) Long id, Model model){
        this.productService.deleteProductById(id);
        model.addAttribute("products", this.productService.findAll());
        return "admin/products";
    }

    @PostMapping(value = "/admin/edit_product")
    public String editProduct(@RequestParam(required = true) Long id, Model model){
        model.addAttribute("productDTO", toDTO(this.productService.getById(id)));
        return "admin/add_product";
    }

}
