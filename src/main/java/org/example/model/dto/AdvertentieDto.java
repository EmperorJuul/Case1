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
    boolean verkocht;

    @Override
    public String toString() {
        String toString = "";

        if (verkocht) {
            toString += """
                    XXX VERKOCHT XXX
                    """;
        }

        toString += String.format("""
                Titel: %s
                Soort: %s
                Omschrijving: %s
                Prijs: %d
                Categorie: %s
                Levering: %s
                """, titel, soort, omschrijving, prijs, categorie, levering);

        return toString;
    }


}
