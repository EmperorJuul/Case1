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
                        WELKOM OP BELASTINGPLAATS    
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
                    System.out.println("\nONGELDIGE KEUZE");
                    Main.wait(1);

            }
        }
    }

    public void login() {
        System.out.printf("\nGEBRUIKERSNAAM: ");
        String gebruikersnaam = scanner.next();
        if (gebruikersnaam.equals("x")) {
            return;
        }
        System.out.printf("\nWACHTWOORD: ");
        String wachtwoord = scanner.next();

        gebruiker = controller.getGebruiker(gebruikersnaam);

        if (gebruiker == null) {
            System.out.println("\nGEEN GEBRUIKER GEVONDEN, PROBEER OPNIEUW");
            Main.wait(1);
            login();
        } else if (controller.checkWachtwoord(gebruiker, wachtwoord)) {
            System.out.printf("\nWELKOM %s", gebruikersnaam);
            Main.wait(1);
            Homepagina homepagina = new Homepagina(gebruiker);
            homepagina.home();
        } else {
            System.out.println("\nONJUIST WACHTWOORD, PROBEER OPNIEUW");
            Main.wait(1);
            login();
        }
    }

    public void sluitApplicatie() {
        System.out.println("BEDANKT, EN TOT ZIENS!");
        System.exit(0);
    }
}
