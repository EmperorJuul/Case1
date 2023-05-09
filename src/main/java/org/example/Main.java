package org.example;

import org.example.DataLoader.DataLoader;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DataLoader d = new DataLoader();

        while (true) {
            startscherm();
        }
    }

    public static void startscherm() {
        System.out.println("""
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
        Scanner scanner = new Scanner(System.in);
        int keuze = scanner.nextInt();

        switch (keuze) {
            case 1:
                break;
            case 2:
                sluitApplicatie();
                break;
        }
    }

    public static void sluitApplicatie() {
        System.out.println("BEDANKT, EN TOT ZIENS!");
        System.exit(0);
    }
}