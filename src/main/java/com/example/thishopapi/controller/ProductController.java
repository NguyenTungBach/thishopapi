package com.example.thishopapi.controller;

import com.example.thishopapi.entity.Product;
import com.example.thishopapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class ProductController {
    @Autowired
    ProductService productService;


    @RequestMapping(value = "product",method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Product product){
        productService.saveProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "product",method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAllUser(){
        List<Product> productList = productService.findAll();
        if (productList.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
    }

    @RequestMapping(value = "product/{id}",method = RequestMethod.POST)
    public ResponseEntity<?> ByProductId(
            @PathVariable("id") Integer id,
            @RequestParam("quantity") Integer quantity
    ){
        Product product = productService.buyProduct(id,quantity);
        if (product == null){
            return new ResponseEntity<Product>(product,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
}
