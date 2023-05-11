package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.dataloader.DataLoader;
import org.example.model.Levering;
import org.example.model.dto.GebruikerDto;
import org.example.view.NieuweAdvertentie;
import org.example.view.Startscherm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);
    public static final EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    public static final EntityTransaction transaction = em.getTransaction();


    public static void main(String[] args) {

        DataLoader d = new DataLoader();
        Startscherm startscherm = new Startscherm();
        //startscherm.start();

        List<Levering> leveringList = Arrays.asList(Levering.AFHALEN, Levering.VERSTUREN);
        GebruikerDto gebruikerDto = new GebruikerDto("test", leveringList);
        NieuweAdvertentie nieuweAdvertentie = new NieuweAdvertentie(gebruikerDto);
        nieuweAdvertentie.nieuweAdvertentie();

    }

    public static void wait(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException ex) {
            //TODO log exception
        }
    }


}