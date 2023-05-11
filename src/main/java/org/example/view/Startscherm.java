package org.example.view;

import org.example.Main;
import org.example.controller.GebruikerController;
import org.example.model.Dao.GebruikerDao;
import org.example.model.dto.GebruikerDto;

import static org.example.Main.em;
import static org.example.Main.scanner;

public class Startscherm {

    private static GebruikerDto gebruiker;
    private GebruikerDao dao = new GebruikerDao(em);

    private GebruikerController controller = new GebruikerController();


    public void start() {
        while (true) {
            System.out.println("""
                        \n\n
                        Welkom op belastingplaats    
                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                    X                               X
                    X   1. Log in                   X
                    X   2. Sluit applicatie         X
                    X                               X
                    X                               X
                    X                               X
                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                    """);

            int keuze = scanner.nextInt();

            switch (keuze) {
                case 1:
                    login();
                    break;
                case 2:
                    sluitApplicatie();
                    break;
                default:
                    System.out.println("\nOngeldige keuze");
                    Main.wait(1);

            }
        }
    }

    public void login() {
        System.out.printf("\nGebruikersnaam: ");
        String gebruikersnaam = scanner.next();
        if (gebruikersnaam.equals("x")) {
            return;
        }
        System.out.printf("\nWachtwoord: ");
        String wachtwoord = scanner.next();

        gebruiker = controller.getGebruiker(gebruikersnaam);

        if (gebruiker == null) {
            System.out.println("\nGeen gebruiker gevonden, probeer opnieuw");
            Main.wait(1);
            login();
        } else if (controller.checkWachtwoord(gebruiker, wachtwoord)) {
            System.out.printf("\nWelkom %s", gebruikersnaam);
            Main.wait(1);
            Homepagina homepagina = new Homepagina(gebruiker);
            homepagina.home();
        } else {
            System.out.println("\nOnjuist wachtwoord, probeer opnieuw");
            Main.wait(1);
            login();
        }
    }

    public void sluitApplicatie() {
        System.out.println("Bedankt, en tot ziens!");
        System.exit(0);
    }
}
