package com.uniyaz.product.rest;

import com.uniyaz.product.entity.Product;
import com.uniyaz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "/all")
    public ResponseEntity findAll(){
        List<Product> products= productService.findAll();
        ResponseEntity responseEntity = new ResponseEntity(products, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(path = "/save")
    public ResponseEntity save(@RequestBody Product product){
        Product newproduct= productService.save(product);
        ResponseEntity responseEntity = new ResponseEntity(newproduct, HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping(path = "/update")
    public ResponseEntity update(@RequestBody Product product){
        Product newproduct= productService.update(product);
        ResponseEntity responseEntity = new ResponseEntity(newproduct, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
