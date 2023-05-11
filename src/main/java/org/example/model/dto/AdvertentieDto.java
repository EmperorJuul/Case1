package org.example.model.dto;

import org.example.model.Levering;
import org.example.model.Soort;


public record AdvertentieDto(
        String titel,
        Soort soort,
        String categorie,
        Levering levering,
        String omschrijving,
        int prijs
) {

}
