package org.example.view;

import org.example.Main;
import org.example.controller.AdvertentieController;
import org.example.model.dto.AdvertentieDto;
import org.example.model.dto.GebruikerDto;

import java.util.Arrays;
import java.util.List;

import static org.example.Main.scanner;
import static org.example.view.Format.*;

public class AdvertentiePagina {

    GebruikerDto gebruiker;

    AdvertentieController controller = new AdvertentieController();

    public AdvertentiePagina(GebruikerDto gebruiker) {
        this.gebruiker = gebruiker;
    }

    public void bekijkAdvertenties() {
        while (true) {
            System.out.printf("""
                    Advertenties
                    =================================
                    """);
            for (AdvertentieDto advertentie : controller.alleAdvertenties()) {
                System.out.printf("\n" + advertentie.toString() + "\n");
            }
            printPreMenu("Kies advertentie");
            int teller = 1;
            for (AdvertentieDto advertentie : controller.alleAdvertenties()) {
                System.out.println(formatOpties(teller, advertentie.getTitel()));
                teller++;
            }
            System.out.println(formatOpties(0, "Terug"));
            printPostMenu();
            int keuze = scanner.nextInt();
            scanner.nextLine();

            switch (keuze) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Ongeldige keuze");
                    Main.wait(1);
                    break;
            }
        }


    }

    public void mijnAdvertenties() {
        while (true) {
            System.out.println("""
                    Mijn advertenties
                    =================================
                    """);
            List<AdvertentieDto> advertenties = controller.alleAdvertentiesVanGebruiker(gebruiker);
            int teller = 0;
            for (AdvertentieDto advertentie : advertenties) {
                teller++;
                System.out.printf("""
                                                
                        Id: %d
                        %s
                        """, teller, advertentie.toString());
            }
            printPreMenu("Selecteer advertentie");
            for (int i = 1; i <= teller; i++) {
                System.out.println(formatOpties(i, ""));
            }
            System.out.println(formatOpties(0, "Terug"));
            printPostMenu();
            int advertentie = scanner.nextInt();
            scanner.nextLine();
            if (advertentie == 0) {
                return;
            } else if (advertentie > teller) {
                System.out.println("Ongeldige keuze");
                Main.wait(1);
                break;
            }

            List<String> opties = Arrays.asList("Markeer beschikbaar", "Markeer verkocht", "Terug");
            printPreMenu("Selecteer actie");
            printOpties(opties);
            printPostMenu();
            int actie = scanner.nextInt();
            scanner.nextLine();

            AdvertentieDto update;

            switch (actie) {
                case 1:
                    update = advertenties.get(advertentie - 1);
                    update.setVerkocht(false);
                    controller.update(update);
                    System.out.println("Advertentie gemarkeerd als beschikbaar");
                    Main.wait(1);
                    break;
                case 2:
                    update = advertenties.get(advertentie - 1);
                    update.setVerkocht(true);
                    controller.update(update);
                    System.out.println("Advertentie gemarkeerd als verkocht");
                    Main.wait(1);
                    break;
                case 3:
                    return;
                default:
                    System.out.printf("Ongeldige keuze");
                    Main.wait(1);
            }
        }
    }
}
