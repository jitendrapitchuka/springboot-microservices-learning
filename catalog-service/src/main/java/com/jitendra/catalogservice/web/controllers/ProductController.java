package com.jitendra.catalogservice.web.controllers;

import com.jitendra.catalogservice.domain.PagedResult;
import com.jitendra.catalogservice.domain.Product;

import com.jitendra.catalogservice.domain.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
 class ProductController {


    private final ProductService productService;

     ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name="page",defaultValue = "1")int pageNo){
        return productService.getProducts(pageNo);
    }


}
