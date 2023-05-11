package org.example.view;

import org.example.Main;
import org.example.model.Advertentie;
import org.example.model.Categorie;
import org.example.model.Levering;
import org.example.model.Soort;
import org.example.model.dto.GebruikerDto;

import static org.example.Main.scanner;

public class NieuweAdvertentie {

    Advertentie advertentie = new Advertentie();

    GebruikerDto gebruiker;

    public NieuweAdvertentie(GebruikerDto gebruiker) {
        this.gebruiker = gebruiker;
    }

    public void nieuweAdvertentie() {
        while (true) {
            System.out.println("""
                    \n\n
                           Nieuwe advertentie                      
                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                    X                               X
                    X   1. Titel                    X
                    X   2. Product/dienst           X
                    X   3. Categorie                X
                    X   4. Levering                 X
                    X   5. Omschrijving             X
                    X   6. Vraagprijs               X
                    X                               X
                    X                               X
                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                    """);
            int keuze = scanner.nextInt();
            scanner.nextLine();

            switch (keuze) {
                case 1:
                    titel();
                    break;
                case 2:
                    soort();
                    break;
                case 3:
                    categorie();
                    break;
                case 4:
                    levering();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\nOngeldige keuze");
                    Main.wait(1);
            }
        }
    }

    public void titel() {
        String titel = advertentie.getTitel() == null ? "" : advertentie.getTitel();
        System.out.printf("\nTitel (%s): ", titel);
        titel = scanner.nextLine();
        advertentie.setTitel(titel);
    }

    public void soort() {
        System.out.printf("""
                \n\n
                (%s)                    
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                X                               X
                X   1. Product                  X
                X   2. Dienst                   X
                X                               X
                X                               X
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                """, advertentie.getSoort() == null ? "" : advertentie.getSoort().toString().toLowerCase());

        int keuze = scanner.nextInt();
        scanner.nextLine();
        switch (keuze) {
            case 1:
                advertentie.setSoort(Soort.PRODUCT);
                break;
            case 2:
                advertentie.setSoort(Soort.DIENST);
                break;
            default:
                System.out.println("\nOngeldige keuze");
                Main.wait(1);
        }
    }

    public void categorie() {
        System.out.printf("""
                 \n\n
                (%s)                    
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                X                               X
                """, advertentie.getCategorie() == null ? "" : advertentie.getCategorie().toString().toLowerCase());


        int teller = 1;
        for (Categorie categorie : Categorie.values()) {
            String tekst = "X   ";
            tekst += String.format("%d.%-26s", teller, categorie.toString().toLowerCase());
            tekst += "X";
            System.out.println(tekst);
            teller++;
        }

        System.out.printf("""
                X                               X
                X                               X
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                """);
        int keuze = scanner.nextInt();
        scanner.nextLine();
        if (keuze > Categorie.values().length || keuze < 1) {
            System.out.println("\nOngeldige keuze");
            Main.wait(1);
        } else {
            advertentie.setCategorie(Categorie.values()[keuze - 1]);
        }
    }

    public void levering() {
        System.out.printf("""
                 \n\n
                (%s)                    
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                X                               X
                """, advertentie.getLevering() == null ? "" : advertentie.getLevering().toString().toLowerCase());


        int teller = 1;
        for (Levering levering : gebruiker.levering()) {
            String tekst = "X   ";
            tekst += String.format("%d.%-26s", teller, levering.toString().toLowerCase());
            tekst += "X";
            System.out.println(tekst);
            teller++;
        }

        System.out.printf("""
                X                               X
                X                               X
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                """);

        int keuze = scanner.nextInt();
        scanner.nextLine();
        if (keuze > gebruiker.levering().size() || keuze < 1) {
            System.out.println("\nOngeldige keuze");
            Main.wait(1);
        } else {
            advertentie.setLevering(gebruiker.levering().get(keuze - 1));
        }

    }
}
