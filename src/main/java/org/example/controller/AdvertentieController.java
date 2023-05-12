package org.example.controller;

import org.example.model.Advertentie;
import org.example.model.Dao.AdvertentieDao;
import org.example.model.dto.AdvertentieDto;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.em;

public class AdvertentieController {

    AdvertentieDao dao = new AdvertentieDao(em);

    public void save(AdvertentieDto dto) {
        dao.insert(vanDtoNaarAdvertentie(dto));
    }

    public List<AdvertentieDto> alleAdvertenties() {
        List<AdvertentieDto> dtoList = new ArrayList<>();
        for (Advertentie advertentie : dao.selectAll()) {
            dtoList.add(vanAdvertentieNaarDto(advertentie));
        }
        return dtoList;
    }

    public Advertentie vanDtoNaarAdvertentie(AdvertentieDto dto) {
        Advertentie advertentie = new Advertentie();
        advertentie.setTitel(dto.getTitel());
        advertentie.setSoort(dto.getSoort());
        advertentie.setCategorie(dto.getCategorie());
        advertentie.setLevering(dto.getLevering());
        advertentie.setOmschrijving(dto.getOmschrijving());
        advertentie.setPrijs(dto.getPrijs());
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
        return dto;
    }
}
