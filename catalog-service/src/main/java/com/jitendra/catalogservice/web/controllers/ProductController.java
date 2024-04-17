package com.jitendra.catalogservice.web.controllers;

import com.jitendra.catalogservice.domain.PagedResult;
import com.jitendra.catalogservice.domain.Product;

import com.jitendra.catalogservice.domain.ProductNotFoundException;
import com.jitendra.catalogservice.domain.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code){
         return productService.getProductsByCode(code)
                 .map(ResponseEntity::ok)
                 .orElseThrow(()-> ProductNotFoundException.forCode(code));
    }

}
