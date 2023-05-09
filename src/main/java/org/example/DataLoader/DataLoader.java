package org.example.DataLoader;

import org.example.Dao.GebruikerDao;
import org.example.Entiteiten.Gebruiker;

public class DataLoader {

    GebruikerDao dao = new GebruikerDao();

    public DataLoader() {
        Gebruiker gebruiker1 = Gebruiker.builder().email("test@email.com").wachtwoord("wachtwoord").build();
        dao.insert(gebruiker1);
    }
}
