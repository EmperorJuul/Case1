package org.example.controller;

import org.example.model.Dao.GebruikerDao;
import org.example.model.Gebruiker;
import org.example.model.dto.GebruikerDto;
import org.example.model.dto.GebruikerMapper;
import org.mapstruct.factory.Mappers;

import static org.example.Main.em;

public class GebruikerController {


    GebruikerMapper mapper = Mappers.getMapper(GebruikerMapper.class);

    GebruikerDao dao = new GebruikerDao(em);

    public GebruikerDto getGebruiker(String email) {
        Gebruiker gebruiker = dao.select(email);
        if (gebruiker == null) {
            return null;
        } else {
            return mapper.naarDto(gebruiker);
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
        Gebruiker gebruiker = dao.select(dto.getEmail());
        if (gebruiker.getWachtwoord().equals(wachtwoord)) {
            return true;
        }
        return false;
    }

//    private GebruikerDto vanGebruikerNaarDto(Gebruiker gebruiker) {
//        GebruikerDto gebruikerDto = new GebruikerDto(gebruiker.getEmail(), gebruiker.getLevering());
//        return gebruikerDto;
//    }


}
