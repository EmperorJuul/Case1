package org.example.controller;

import org.example.model.Advertentie;
import org.example.model.Dao.AdvertentieDao;
import org.example.model.Dao.GebruikerDao;
import org.example.model.Gebruiker;
import org.example.model.dto.AdvertentieDto;
import org.example.model.dto.GebruikerDto;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.em;

public class AdvertentieController {

    AdvertentieDao advertentieDao = new AdvertentieDao(em);

    GebruikerDao gebruikerDao = new GebruikerDao(em);

    public void save(AdvertentieDto dto) {
        advertentieDao.insert(vanDtoNaarAdvertentie(dto));
    }

    public void update(AdvertentieDto dto) {
        advertentieDao.merge(vanDtoNaarAdvertentie(dto));
    }

    public List<AdvertentieDto> alleAdvertenties() {
        List<AdvertentieDto> dtoList = new ArrayList<>();
        for (Advertentie advertentie : advertentieDao.selectAll()) {
            dtoList.add(vanAdvertentieNaarDto(advertentie));
        }
        return dtoList;
    }

    public List<AdvertentieDto> alleAdvertentiesVanGebruiker(GebruikerDto dto) {
        Gebruiker gebruiker = gebruikerDao.select(dto.getEmail());
        List<AdvertentieDto> advertentieDtos = new ArrayList<>();
        for (Advertentie advertentie : advertentieDao.selectWhereGebruiker(gebruiker)) {
            advertentieDtos.add(vanAdvertentieNaarDto(advertentie));
        }
        return advertentieDtos;
    }

    public Advertentie vanDtoNaarAdvertentie(AdvertentieDto dto) {
        Advertentie advertentie = new Advertentie();
        advertentie.setTitel(dto.getTitel());
        advertentie.setSoort(dto.getSoort());
        advertentie.setCategorie(dto.getCategorie());
        advertentie.setLevering(dto.getLevering());
        advertentie.setOmschrijving(dto.getOmschrijving());
        advertentie.setPrijs(dto.getPrijs());
        advertentie.setVerkocht(dto.isVerkocht());
        advertentie.setGebruiker(gebruikerDao.select(dto.getGebruikersnaam()));
        if (dto.getId() != null) {
            advertentie.setId(dto.getId());
        }
        return advertentie;
    }

    public AdvertentieDto vanAdvertentieNaarDto(Advertentie advertentie) {
        AdvertentieDto dto = new AdvertentieDto();
        dto.setTitel(advertentie.getTitel());
        dto.setSoort(advertentie.getSoort());
        dto.setCategorie(advertentie.getCategorie());
        dto.setLevering(advertentie.getLevering());
        dto.setOmschrijving(advertentie.getOmschrijving());
        dto.setPrijs(advertentie.getPrijs());
        dto.setVerkocht(advertentie.isVerkocht());
        dto.setGebruikersnaam(advertentie.getGebruiker().getEmail().toString());
        dto.setId(advertentie.getId());
        return dto;
    }
}
