package org.example.view;

import org.example.Main;
import org.example.model.dto.GebruikerDto;

import java.util.Arrays;
import java.util.List;

import static org.example.Main.scanner;
import static org.example.view.Format.*;

public class Homepagina {

    private GebruikerDto gebruiker;

    public Homepagina(GebruikerDto gebruiker) {
        this.gebruiker = gebruiker;
    }

    public void home() {
        while (true) {

            printPreMenu("Homepagina");

            List<String> opties = Arrays.asList("Maak advertentie", "Uitloggen");

            int teller = 1;
            for (String item : opties) {
                System.out.println(formatOpties(teller, item));
                teller++;
            }

            printPostMenu();

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
