package com.uniyaz.product.rest;

import com.uniyaz.product.entity.Product;
import com.uniyaz.product.entity.User;
import com.uniyaz.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/save")
    public ResponseEntity save(@RequestBody User user){
        User user1 = userService.save(user);
        ResponseEntity responseEntity = new ResponseEntity(user1, HttpStatus.CREATED);
        return responseEntity;
    }
}
