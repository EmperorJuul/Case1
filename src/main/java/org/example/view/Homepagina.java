package org.example.view;

import org.example.Main;
import org.example.model.dto.GebruikerDto;

import static org.example.Main.scanner;

public class Homepagina {

    private GebruikerDto gebruiker;

    public Homepagina(GebruikerDto gebruiker) {
        this.gebruiker = gebruiker;
    }

    public void home() {
        while (true) {
            System.out.println("""
                    \n\n
                              HOMEPAGINA                       
                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                    X                               X
                    X   1. MAAK ADVERTENTIE         X
                    X   2. UITLOGGEN                X
                    X                               X
                    X                               X
                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                    """);

            int keuze = scanner.nextInt();

            switch (keuze) {
                case 1:
                    NieuweAdvertentie nieuweAdvertentie = new NieuweAdvertentie(gebruiker);
                    nieuweAdvertentie.nieuweAdvertentie();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("ONGELDIGE KEUZE");
                    Main.wait(1);
            }

        }
    }
}
