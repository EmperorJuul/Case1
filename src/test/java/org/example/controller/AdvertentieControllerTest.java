package org.example.controller;

import org.example.model.*;
import org.example.model.Dao.AdvertentieDao;
import org.example.model.Dao.GebruikerDao;
import org.example.model.dto.AdvertentieDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AdvertentieControllerTest {

    @Mock
    private GebruikerDao gebruikerDao;

    @Mock
    private AdvertentieDao dao;

    @InjectMocks
    private AdvertentieController sut;

    @Test
    public void alleAdvertentiesGeeftEenLijstVanAdvertentiesTerug() {

    }

    @Test
    public void advertentieNaarDtoConversieGeeftGeenError() {
        Gebruiker gebruiker = Gebruiker.builder().email("gebuiker").wachtwoord("wachtwoord").build();


        Advertentie advertentie = Advertentie.builder()
                .titel("Mooie Advertentie")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("Mooie omschrijving")
                .prijs(50)
                .gebruiker(gebruiker)
                .build();


        AdvertentieDto expected = AdvertentieDto.builder().titel("Mooie Advertentie")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("Mooie omschrijving")
                .prijs(50)
                .gebruikersnaam(gebruiker.getEmail())
                .build();

        AdvertentieDto actual = sut.vanAdvertentieNaarDto(advertentie);

        assertEquals(expected, actual);
    }

    @Test
    public void dtoNaarAdvertentieConversieGeeftGeenError() {
        Gebruiker gebruiker = Gebruiker.builder().email("gebuiker").wachtwoord("wachtwoord").build();

        Mockito.when(gebruikerDao.select(gebruiker.getEmail())).thenReturn(gebruiker);

        Advertentie expected = Advertentie.builder()
                .titel("Mooie Advertentie2")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("Mooie omschrijving2")
                .prijs(50)
                .gebruiker(gebruiker)
                .build();

        AdvertentieDto dto = AdvertentieDto.builder().titel("Mooie Advertentie2")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("Mooie omschrijving2")
                .prijs(50)
                .gebruikersnaam(gebruiker.getEmail()).build();

        Advertentie actual = sut.vanDtoNaarAdvertentie(dto);

        assertEquals(expected, actual);

    }

}