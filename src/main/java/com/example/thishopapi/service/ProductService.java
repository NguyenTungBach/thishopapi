package com.example.thishopapi.service;

import com.example.thishopapi.entity.Product;
import com.example.thishopapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product buyProduct(int id,int quantity) {
        Product product = productRepository.findById(id).orElse(null);
        if (product!=null){
            product.setQuantity(product.getQuantity() - quantity);
            return productRepository.save(product);
        }
        return product;
    }
}
