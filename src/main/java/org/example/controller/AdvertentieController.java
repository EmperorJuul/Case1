package org.example.controller;

import org.example.model.Advertentie;
import org.example.model.Dao.AdvertentieDao;
import org.example.model.dto.AdvertentieDto;

import static org.example.Main.em;

public class AdvertentieController {

    AdvertentieDao dao = new AdvertentieDao(em);

    public void save(AdvertentieDto dto) {
        dao.insert(vanDtoNaarAdvertentie(dto));
    }

    private Advertentie vanDtoNaarAdvertentie(AdvertentieDto dto) {
        Advertentie advertentie = new Advertentie();
        advertentie.setTitel(dto.getTitel());
        advertentie.setSoort(dto.getSoort());
        advertentie.setCategorie(dto.getCategorie());
        advertentie.setLevering(dto.getLevering());
        advertentie.setOmschrijving(dto.getOmschrijving());
        advertentie.setPrijs(dto.getPrijs());
        return advertentie;
    }
}
