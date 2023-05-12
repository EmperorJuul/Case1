package org.example.view;

import org.example.controller.AdvertentieController;
import org.example.model.dto.AdvertentieDto;
import org.example.model.dto.GebruikerDto;

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
            }
            printPostMenu();
            scanner.nextInt();
            scanner.nextLine();
        }


    }
}
