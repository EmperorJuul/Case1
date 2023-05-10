package org.example.model.Dao;

import jakarta.persistence.EntityManager;
import org.example.model.Gebruiker;

public class GebruikerDao extends Dao<Gebruiker, String> {
    public GebruikerDao(EntityManager em) {
        super(em);
    }

}
