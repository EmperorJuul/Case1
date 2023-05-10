package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.dataloader.DataLoader;
import org.example.view.Startscherm;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);
    public static final EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    public static final EntityTransaction transaction = em.getTransaction();


    public static void main(String[] args) {


        DataLoader d = new DataLoader();
        Startscherm startscherm = new Startscherm();
        startscherm.start();
    }

    public static void wait(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException ex) {
            //TODO log exception
        }
    }


}