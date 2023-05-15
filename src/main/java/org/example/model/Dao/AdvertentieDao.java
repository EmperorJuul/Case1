package org.example.model.Dao;

import jakarta.persistence.EntityManager;
import org.example.model.Advertentie;
import org.example.model.Gebruiker;

import java.util.List;

public class AdvertentieDao extends Dao<Advertentie, Long> {
    public AdvertentieDao(EntityManager em) {
        super(em);
    }

    public List<Advertentie> selectAll() {
        return em.createQuery("select a from Advertentie a").getResultList();
    }

    public List<Advertentie> selectWhereGebruiker(Gebruiker gebruiker) {
        return em.createQuery("select a from Advertentie a where a.gebruiker = :gebruiker").setParameter("gebruiker", gebruiker).getResultList();
    }
}
