package com.uniyaz.product.rest;

import com.uniyaz.product.entity.Basket;
import com.uniyaz.product.entity.Product;
import com.uniyaz.product.service.BasketService;
import com.uniyaz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/basket")
public class BasketController {
    @Autowired
    BasketService basketService;

    @Autowired
    ProductService productService;

    @GetMapping(path = "/all")
    public ResponseEntity findAll(){
        List<Basket> baskets= basketService.findAll();
        ResponseEntity responseEntity = new ResponseEntity(baskets, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(path = "/save")
    public ResponseEntity save(@RequestBody Product product){
        Basket basket1 = new Basket();
        basket1.setProduct(product);
        basket1 = basketService.save(basket1);
        ResponseEntity responseEntity = new ResponseEntity(basket1, HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        basketService.delete(id);
    }

    @GetMapping(path = "/productname")
    public ResponseEntity findByProductName(){
        List<Basket> baskets= basketService.findByProductName();
        ResponseEntity responseEntity = new ResponseEntity(baskets, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(path = "/delete/all")
    public void delete(@RequestBody List<Basket> basketList){
        basketService.deleteAll(basketList);
    }

}
