package org.example.view;

import org.example.Main;
import org.example.model.Gebruiker;

import static org.example.Main.scanner;

public class Homepagina {

    private Gebruiker gebruiker;

    public Homepagina(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public void home() {
        while (true) {
            System.out.println("""
                    \n\n
                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                    X                               X
                    X   1. MAAK ADVERTENTIE         X
                    X                               X
                    X                               X
                    X                               X
                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                    """);

            int keuze = scanner.nextInt();

            switch (keuze) {
                case 1:
                    break;
                default:
                    System.out.println("ONGELDIGE KEUZE");
                    Main.wait(1);
            }

        }
    }
}
