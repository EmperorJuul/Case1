package org.example.view;

import java.util.List;

public class Format {

    public static void printPreMenu(String header) {
        System.out.printf("""
                \n\n
                %s                  
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                X                               X
                """, header);
    }

    private static String formatOpties(int index, String optie) {
        String tekst = "X   ";
        tekst += String.format("%d.%-26s", index, optie.toLowerCase());
        tekst += "X";
        return tekst;
    }

    public static void printOpties(List opties) {
        int teller = 1;
        for (Object item : opties) {
            System.out.println(formatOpties(teller, item.toString()));
            teller++;
        }
    }

    public static void printOpties(List opties, boolean terugKnop) {
        int teller = 1;
        for (Object item : opties) {
            System.out.println(formatOpties(teller, item.toString()));
            teller++;
        }
        System.out.println(formatOpties(0, "Terug"));
    }

    public static void printPostMenu() {
        System.out.printf("""
                X                               X
                X                               X
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                                
                """);
    }
}
