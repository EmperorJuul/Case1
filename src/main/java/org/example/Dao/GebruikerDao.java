package org.example.Dao;

import jakarta.persistence.EntityManager;
import org.example.Entiteiten.Gebruiker;

public class GebruikerDao extends Dao<Gebruiker, String> {
    public GebruikerDao(EntityManager em) {
        super(em);
    }

}
