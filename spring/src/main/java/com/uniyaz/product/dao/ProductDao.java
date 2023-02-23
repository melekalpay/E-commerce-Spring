package com.uniyaz.product.dao;

import com.uniyaz.product.common.BaseDao;
import com.uniyaz.product.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends BaseDao<Product> {
    public ProductDao() {
        super(Product.class);
    }
}
