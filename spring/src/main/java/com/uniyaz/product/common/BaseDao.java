package com.uniyaz.product.common;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public abstract class BaseDao <T extends BaseEntity> {
    public Class<T> t;

    @Autowired
    EntityManager entityManager;

    public BaseDao(Class<T> t) {
        this.t = t;
    }

    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(t);
        Root<T> root = criteriaQuery.from(t);
        criteriaQuery.select(root);
        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    public T save(T entity) {
        return entityManager.merge(entity);
    }

    public T findById(Long id) {
        return entityManager.find(t, id);
    }

    @Transactional
    public void delete(T entity) {
        entityManager.remove(entity);
    }


}
