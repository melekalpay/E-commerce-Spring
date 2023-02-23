package com.uniyaz.product.service;

import com.uniyaz.product.dao.ProductDao;
import com.uniyaz.product.dao.UserDao;
import com.uniyaz.product.entity.Product;
import com.uniyaz.product.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User save(User user){
        return userDao.save(user);
    }
}
