package org.example.view;

import org.example.Main;
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
    String omschrijvingl;
    int prijs;
    GebruikerDto gebruiker;

    public NieuweAdvertentie(GebruikerDto gebruiker) {
        this.gebruiker = gebruiker;
    }

    public void nieuweAdvertentie() {
        while (true) {

            List<String> opties = Arrays.asList("Titel", "Product/dienst", "Categorie", "Levering", "Omschrijving", "Vraagprijs", "Opslaan");

            printPreMenu("Nieuwe advertentie");
            printOpties(opties);
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
                            omschrijvingl,
                            prijs);

                    break;
                case 0:
                    return;
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
        if (!titel.isEmpty()) {
            advertentie.setTitel(titel);
        }
    }

    public void soort() {

        List<String> opties = Arrays.asList("Product", "Dienst");

        printPreMenu(String.format("Huidige keuze: %s", advertentie.getSoort() == null ? "" : advertentie.getSoort().toString().toLowerCase()));
        printOpties(opties);
        printPostMenu();

        int keuze = scanner.nextInt();
        scanner.nextLine();
        switch (keuze) {
            case 1:
                advertentie.setSoort(Soort.PRODUCT);
                break;
            case 2:
                advertentie.setSoort(Soort.DIENST);
                break;
            case 0:
                break;
            default:
                System.out.println("\nOngeldige keuze");
                Main.wait(1);
        }
    }

    public void categorie() {

        printPreMenu(String.format("huidige keuze: %s", advertentie.getCategorie() == null ? "" : advertentie.getCategorie().toString().toLowerCase()));
        printOpties(Arrays.asList(Categorie.values()));
        printPostMenu();

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

        printPreMenu(String.format("Huidige keuze: %s", advertentie.getLevering() == null ? "" : advertentie.getLevering().toString().toLowerCase()));
        printOpties(gebruiker.levering());
        printPostMenu();

        int keuze = scanner.nextInt();
        scanner.nextLine(
        );
        if (keuze > gebruiker.levering().size() || keuze < 1) {
            System.out.println("\nOngeldige keuze");
            Main.wait(1);
        } else {
            advertentie.setLevering(gebruiker.levering().get(keuze - 1));
        }

    }

    public void omschrijving() {
        String omschrijving = advertentie.getOmschrijving() == null ? "" : advertentie.getOmschrijving();


        System.out.printf("\nOmschrijving (%s): ", omschrijving);
        omschrijving = scanner.nextLine();
        if (!omschrijving.isEmpty()) {
            advertentie.setOmschrijving(omschrijving);
        }
    }

    public void vraagprijs() {
        int prijs = advertentie.getPrijs();
        System.out.printf("\nPrijs (%s): ", prijs);
        prijs = scanner.nextInt();
        advertentie.setPrijs(prijs);
    }


}
