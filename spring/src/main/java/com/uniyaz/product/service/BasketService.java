package com.uniyaz.product.service;

import com.uniyaz.product.dao.BasketDao;
import com.uniyaz.product.entity.Basket;
import com.uniyaz.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    private BasketDao basketDao;

    @Autowired
    public BasketService(BasketDao basketDao) {
        this.basketDao = basketDao;
    }

    @Autowired
    ProductService productService;

    public List<Basket> findAll(){
        return basketDao.findAll();
    }

    public Basket save(Basket basket){
        Product product = productService.findById(basket.getProduct().getId());
        basket.setProduct(product);
        return basketDao.save(basket);
    }

    public void delete(Long id){
        Basket basket = basketDao.findById(id);
        basketDao.delete(basket);
    }

    public List<Basket> findByProductName(){
        return basketDao.findByProductName();
    }

    public void deleteAll(List<Basket> basketList){
         basketList= basketDao.findAll();
        for(int i=0;i<basketList.size();i++){
            basketDao.delete(basketList.get(i));
        }
    }


}
