package com.example.CosmeticsInciStore.mapper;

import com.example.CosmeticsInciStore.DTO.ProductDTO;
import com.example.CosmeticsInciStore.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setAmount(productDTO.getAmount());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setMeasure(productDTO.getMeasure());
        product.setDescription(productDTO.getDescription());
        return product;
    }

    public static ProductDTO toDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setAmount(product.getAmount());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory(product.getCategory());
        productDTO.setMeasure(product.getMeasure());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }
}
