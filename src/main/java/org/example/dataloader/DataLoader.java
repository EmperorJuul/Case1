package org.example.dataloader;

import org.example.model.Dao.GebruikerDao;
import org.example.model.Gebruiker;

import static org.example.Main.em;

public class DataLoader {

    private GebruikerDao dao;

    public DataLoader() {
        dao = new GebruikerDao(em);
        Gebruiker gebruiker1 = Gebruiker.builder().email("test@email.com").wachtwoord("wachtwoord").build();
        Gebruiker gebruiker2 = Gebruiker.builder().email("test").wachtwoord("test").build();
        dao.insert(gebruiker1);
        dao.insert(gebruiker2);
    }
}