package org.example.controller;

import org.example.model.Dao.GebruikerDao;
import org.example.model.Gebruiker;
import org.example.model.dto.GebruikerDto;

import static org.example.Main.em;

public class GebruikerController {

    GebruikerDao dao = new GebruikerDao(em);

    public GebruikerDto getGebruiker(String email) {
        Gebruiker gebruiker = dao.select(email);
        if (gebruiker == null) {
            return null;
        } else {
            return vanGebruikerNaarDto(gebruiker);
        }
    }

    public boolean gebruikerBestaat(String email) {
        Gebruiker gebruiker = dao.select(email);
        if (gebruiker == null) {
            return false;
        }
        return true;

    }

    public boolean checkWachtwoord(GebruikerDto dto, String wachtwoord) {
        Gebruiker gebruiker = dao.select(dto.email());
        if (gebruiker.getWachtwoord().equals(wachtwoord)) {
            return true;
        }
        return false;
    }

    private GebruikerDto vanGebruikerNaarDto(Gebruiker gebruiker) {
        GebruikerDto gebruikerDto = new GebruikerDto(gebruiker.getEmail());
        return gebruikerDto;
    }


}
