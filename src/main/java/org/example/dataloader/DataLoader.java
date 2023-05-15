package org.example.dataloader;

import org.example.model.*;
import org.example.model.Dao.AdvertentieDao;
import org.example.model.Dao.GebruikerDao;

import java.util.Arrays;

import static org.example.Main.em;

public class DataLoader {

    private GebruikerDao gebruikderDao;
    private AdvertentieDao advertentieDao;


    public DataLoader() {
        gebruikderDao = new GebruikerDao(em);
        Gebruiker gebruiker1 = Gebruiker.builder().email("test@email.com").wachtwoord("wachtwoord").levering(Arrays.asList(Levering.VERSTUREN, Levering.AFHALEN, Levering.OPHALEN_MAGAZIJN)).build();
        Gebruiker gebruiker2 = Gebruiker.builder().email("test").wachtwoord("test").levering(Arrays.asList(Levering.AFHALEN, Levering.VERSTUREN)).build();
        gebruikderDao.insert(gebruiker1);
        gebruikderDao.insert(gebruiker2);

        advertentieDao = new AdvertentieDao(em);
        Advertentie advertentie1 = Advertentie.builder()
                .titel("Mooie Advertentie")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("Mooie omschrijving")
                .prijs(50)
                .gebruiker(gebruiker1)
                .build();
        Advertentie advertentie2 = Advertentie.builder()
                .titel("Mooie Advertentie2")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("Mooie omschrijving2")
                .prijs(50)
                .verkocht(true)
                .gebruiker(gebruiker1)
                .build();
        Advertentie advertentie3 = Advertentie.builder()
                .titel("Test advertentie 1")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("Test omschrijving 1")
                .prijs(50)
                .verkocht(false)
                .gebruiker(gebruiker2)
                .build();
        Advertentie advertentie4 = Advertentie.builder()
                .titel("Test advertentie 2")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("test omschrijving 3")
                .prijs(50)
                .verkocht(true)
                .gebruiker(gebruiker2)
                .build();
        Advertentie advertentie5 = Advertentie.builder()
                .titel("Test advertentie 3")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("Test omschrijving 3")
                .prijs(50)
                .verkocht(true)
                .gebruiker(gebruiker2)
                .build();
        advertentieDao.insert(advertentie1);
        advertentieDao.insert(advertentie2);
        advertentieDao.insert(advertentie3);
        advertentieDao.insert(advertentie4);
        advertentieDao.insert(advertentie5);
    }
}
