package org.example.model.Dao;

import jakarta.persistence.EntityManager;
import org.example.model.Advertentie;

public class AdvertentieDao extends Dao<Advertentie, Long> {
    public AdvertentieDao(EntityManager em) {
        super(em);
    }
}
