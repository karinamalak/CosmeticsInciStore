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

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> findAll(Model model){
        model.addAttribute("products", productService.findAll());
            return this.productService.findAll();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public List<Product> findAllProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return this.productService.findAll();
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

}
