package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.Categorie;
import org.example.model.Levering;
import org.example.model.Soort;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertentieDto {
    String titel;
    Soort soort;
    Categorie categorie;
    Levering levering;
    String omschrijving;
    int prijs;

}
