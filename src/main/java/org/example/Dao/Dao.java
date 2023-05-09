package org.example.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public abstract class Dao<T> {

    EntityManager em;
    EntityTransaction transaction;

    public Dao() {
        open();
    }


    public void open() {
        em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
        transaction = em.getTransaction();
    }

    public void insert(T t) {
        transaction.begin();
        em.persist(t);
        transaction.commit();
    }

    public void close() {
        em.close();
    }

}
