package org.example.view;

import org.example.Main;
import org.example.controller.AdvertentieController;
import org.example.model.Categorie;
import org.example.model.Levering;
import org.example.model.Soort;
import org.example.model.dto.AdvertentieDto;
import org.example.model.dto.GebruikerDto;

import java.util.Arrays;
import java.util.List;

import static org.example.Main.scanner;
import static org.example.view.Format.*;

public class NieuweAdvertentie {

    String titel;
    Soort soort;
    Categorie categorie;
    Levering levering;
    String omschrijving;
    int prijs;

    GebruikerDto gebruiker;
    AdvertentieController controller = new AdvertentieController();

    public NieuweAdvertentie(GebruikerDto gebruiker) {
        this.gebruiker = gebruiker;
    }

    public void nieuweAdvertentie() {
        while (true) {

            List<String> opties = Arrays.asList("Titel", "Product/dienst", "Categorie", "Levering", "Omschrijving", "Vraagprijs", "Opslaan");

            printPreMenu("Nieuwe advertentie");
            printOpties(opties, true);
            printPostMenu();

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
                    omschrijving();
                    break;
                case 6:
                    vraagprijs();
                    break;
                case 7:
                    AdvertentieDto advertentie = new AdvertentieDto(titel,
                            soort,
                            categorie,
                            levering,
                            omschrijving,
                            prijs, false);
                    controller.save(advertentie);
                    return;
                case 0:
                    return;
                default:
                    System.out.println("\nOngeldige keuze");
                    Main.wait(1);
            }
        }
    }

    public void titel() {
        String titel = this.titel == null ? "" : this.titel;
        System.out.printf("\nTitel (%s): ", titel);
        titel = scanner.nextLine();
        if (!titel.isEmpty()) {
            this.titel = titel;
        }
    }

    public void soort() {

        List<String> opties = Arrays.asList("Product", "Dienst");

        printPreMenu(String.format("Huidige keuze: %s", soort == null ? "" : soort.toString().toLowerCase()));
        printOpties(opties, true);
        printPostMenu();

        int keuze = scanner.nextInt();
        scanner.nextLine();
        switch (keuze) {
            case 1:
                soort = Soort.PRODUCT;
                break;
            case 2:
                soort = Soort.DIENST;
                break;
            case 0:
                break;
            default:
                System.out.println("\nOngeldige keuze");
                Main.wait(1);
        }
    }

    public void categorie() {

        printPreMenu(String.format("huidige keuze: %s", categorie == null ? "" : categorie.toString().toLowerCase()));
        printOpties(Arrays.asList(Categorie.values()), true);
        printPostMenu();

        int keuze = scanner.nextInt();
        scanner.nextLine();
        if (keuze > Categorie.values().length) {
            System.out.println("\nOngeldige keuze");
            Main.wait(1);
        } else if (keuze == 0) {
            return;
        } else {
            categorie = Categorie.values()[keuze - 1];
        }


    }

    public void levering() {

        printPreMenu(String.format("Huidige keuze: %s", levering == null ? "" : levering.toString().toLowerCase()));
        printOpties(gebruiker.getLevering(), true);
        printPostMenu();

        int keuze = scanner.nextInt();
        scanner.nextLine(
        );
        if (keuze > gebruiker.getLevering().size() || keuze < 1) {
            System.out.println("\nOngeldige keuze");
            Main.wait(1);
        } else {
            levering = gebruiker.getLevering().get(keuze - 1);
        }

    }

    public void omschrijving() {
        String omschrijving = this.omschrijving == null ? "" : this.omschrijving;


        System.out.printf("\nOmschrijving (%s): ", omschrijving);
        omschrijving = scanner.nextLine();
        if (!omschrijving.isEmpty()) {
            this.omschrijving = omschrijving;
        }
    }

    public void vraagprijs() {
        int prijs = this.prijs;
        System.out.printf("\nPrijs (%s): ", prijs);
        prijs = scanner.nextInt();
        this.prijs = prijs;
    }


}
