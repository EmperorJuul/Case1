package org.example.view;

import org.example.model.Advertentie;
import org.example.model.Soort;

import static org.example.Main.scanner;

public class NieuweAdvertentie {

    Advertentie advertentie = new Advertentie();

    public void nieuweAdvertentie() {
        while (true) {
            System.out.println("""
                    \n\n
                           NIEUWE ADVERTENTIE                      
                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                    X                               X
                    X   1. TITEL                    X
                    X   2. PRODUCT/DIENST           X
                    X   3. CATEGORIE                X
                    X   4. LEVERING                 X
                    X   5. OMSCHRIJVING             X
                    X   6. vraagprijs               X
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
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\nONGELDIGE KEUZE");
            }
        }
    }

    public void titel() {
        String titel = advertentie.getTitel().isEmpty() ? "" : advertentie.getTitel();
        System.out.printf("\nTITEL (%s):", titel);
        titel = scanner.nextLine();
        advertentie.setTitel(titel);
    }

    public void soort() {
        System.out.println("""
                \n\n
                      NIEUWE ADVERTENTIE                      
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                X                               X
                X   1. PRODUCT                  X
                X   2. DIENST                   X
                X                               X
                X                               X
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                """);

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
                System.out.println("\nONGELDIGE KEUZE");
        }
    }
}
