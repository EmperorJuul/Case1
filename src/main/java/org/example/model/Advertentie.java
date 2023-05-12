package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Advertentie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean verkocht = false;

    private String titel;
    @Enumerated(EnumType.STRING)
    private Soort soort;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    @Enumerated(EnumType.STRING)
    private Levering levering;

    private String omschrijving;

    private int prijs;

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
