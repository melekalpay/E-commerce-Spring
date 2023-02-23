package com.uniyaz.product.dao;

import com.uniyaz.product.common.BaseDao;
import com.uniyaz.product.entity.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BasketDao extends BaseDao<Basket> {

    @Autowired
    EntityManager entityManager;

    public BasketDao() {
        super(Basket.class);
    }

    public List<Basket> findAll() {
        String hql =
                "Select      basket " +
                        "from          Basket basket " +
                        "Left Join fetch    basket.product  p";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public List<Basket> findByProductName() {
        String hql =
                "Select      p.name " +
                        "from          Basket basket " +
                        "Left Join     basket.product.id p ";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

}
