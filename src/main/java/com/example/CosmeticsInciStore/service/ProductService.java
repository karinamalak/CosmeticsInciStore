package com.example.CosmeticsInciStore.service;

import com.example.CosmeticsInciStore.DTO.ProductDTO;
import com.example.CosmeticsInciStore.entity.Product;
import com.example.CosmeticsInciStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static com.example.CosmeticsInciStore.mapper.ProductMapper.toEntity;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = false)
    public void createProduct(ProductDTO productDTO){
        Product product = toEntity(productDTO);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return productRepository.getOne(id);
    }

    @Transactional
    public void updateProduct(ProductDTO productDTO) {
        productRepository.save(toEntity(productDTO));
    }

    public List<Product> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findAllByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }
}
