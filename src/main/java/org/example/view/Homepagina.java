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

            AdvertentiePagina pagina = new AdvertentiePagina(gebruiker);

            printPreMenu("Homepagina");

            List<String> opties = Arrays.asList("Maak advertentie", "Bekijk advertenties", "Mijn advertenties");


            printOpties(opties);
            System.out.println(formatOpties(0, "Uitloggen"));

            printPostMenu();

            int keuze = scanner.nextInt();


            switch (keuze) {
                case 1:
                    NieuweAdvertentie nieuweAdvertentie = new NieuweAdvertentie(gebruiker);
                    nieuweAdvertentie.nieuweAdvertentie();
                    break;
                case 2:
                    pagina.bekijkAdvertenties();
                    break;
                case 3:
                    pagina.mijnAdvertenties();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("ONGELDIGE KEUZE");
                    Main.wait(1);
            }

        }
    }
}
