package org.example.controller;

import org.example.model.Advertentie;
import org.example.model.Categorie;
import org.example.model.Dao.AdvertentieDao;
import org.example.model.Levering;
import org.example.model.Soort;
import org.example.model.dto.AdvertentieDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AdvertentieControllerTest {

    @Mock
    private AdvertentieDao dao;

    @InjectMocks
    private AdvertentieController sut;

    @Test
    public void alleAdvertentiesGeeftEenLijstVanAdvertentiesTerug() {

    }

    @Test
    public void dtoNaarAdvertentieConversieGeeftGeenError() {
        Advertentie advertentie = Advertentie.builder()
                .titel("Mooie Advertentie")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("Mooie omschrijving")
                .prijs(50)
                .build();


        AdvertentieDto expected = new AdvertentieDto("Mooie Advertentie",
                Soort.DIENST,
                Categorie.OVERIG,
                Levering.REMBOURS,
                "Mooie omschrijving",
                50);


        AdvertentieDto actual = sut.vanAdvertentieNaarDto(advertentie);

        assertEquals(expected, actual);
    }

    @Test
    public void advertentieNaarDtoConversieGeeftGeenError() {
        Advertentie expected = Advertentie.builder()
                .titel("Mooie Advertentie2")
                .soort(Soort.DIENST)
                .categorie(Categorie.OVERIG)
                .levering(Levering.REMBOURS)
                .omschrijving("Mooie omschrijving2")
                .prijs(50)
                .build();

        AdvertentieDto dto = new AdvertentieDto("Mooie Advertentie2",
                Soort.DIENST,
                Categorie.OVERIG,
                Levering.REMBOURS,
                "Mooie omschrijving2",
                50);

        Advertentie actual = sut.vanDtoNaarAdvertentie(dto);

        assertEquals(expected, actual);

    }

}