package org.example.model.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.Data;

import java.lang.reflect.ParameterizedType;

@Data
public abstract class Dao<T, I> {

    EntityManager em;
    EntityTransaction transaction;

    public Dao(EntityManager em) {
        this.em = em;
        this.transaction = em.getTransaction();
    }

    public T select(I i) {
        return em.find(T(), i);
    }

    public void merge(T t) {
        transaction.begin();
        em.merge(t);
        transaction.commit();
    }

    public void insert(T t) {
        transaction.begin();
        em.persist(t);
        transaction.commit();
    }

    private Class<T> T() {
        ParameterizedType thisDaoClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) thisDaoClass.getActualTypeArguments()[0];
    }

}
