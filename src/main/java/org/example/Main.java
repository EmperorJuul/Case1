package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true){
            startscherm();
        }
    }

    public static void startscherm(){
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
    }
}