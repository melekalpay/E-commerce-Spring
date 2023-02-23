package com.uniyaz.product.dao;

import com.uniyaz.product.common.BaseDao;
import com.uniyaz.product.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao extends BaseDao<User> {
    @Autowired
    EntityManager entityManager;

    public UserDao() {
        super(User.class);
    }

    public List<User> findAll() {
        String hql =
                "Select             user " +
                        "from               User user " ;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }
}
