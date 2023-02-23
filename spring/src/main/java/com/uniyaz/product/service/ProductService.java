package com.uniyaz.product.service;

import com.uniyaz.product.dao.ProductDao;
import com.uniyaz.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAll(){
        return productDao.findAll();
    }

    public Product save(Product product){
        return productDao.save(product);
    }

    public Product update(Product product){
        return productDao.save(product);
    }

    public void delete(Long id){
        Product product=productDao.findById(id);
        productDao.delete(product);
    }

    public Product findById(Long id) {
        return productDao.findById(id);
    }
}
