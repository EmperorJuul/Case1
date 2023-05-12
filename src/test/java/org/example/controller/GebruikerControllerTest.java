package org.example.controller;

import org.example.model.Dao.GebruikerDao;
import org.example.model.Gebruiker;
import org.example.model.Levering;
import org.example.model.dto.GebruikerDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GebruikerControllerTest {


    @Mock
    private GebruikerDao dao;

    @InjectMocks
    private GebruikerController sut;

    @Test
    public void getGebruikerVindDeGoedeGebruiker() {
        Gebruiker gebruiker = Gebruiker.builder().email("gebruiker").wachtwoord("wachtwoord").build();
        when(dao.select(gebruiker.getEmail())).thenReturn(gebruiker);

        GebruikerDto expected = new GebruikerDto();
        expected.setEmail("gebruiker");

        GebruikerDto actual = sut.getGebruiker(gebruiker.getEmail());

        assertEquals(expected, actual);
    }

    @Test
    public void getGebruikerKanGeenGebruikerVinden() {
        when(dao.select(anyString())).thenReturn(null);

        GebruikerDto dto = sut.getGebruiker("email");

        assertEquals(null, dto);
    }

    @Test
    public void testCheckWachtwoordMoetKloppen() {
        Gebruiker gebruiker = Gebruiker.builder().email("gebuiker").wachtwoord("wachtwoord").build();

        GebruikerDto dto = new GebruikerDto();
        dto.setEmail("gebruiker");

        when(dao.select(dto.getEmail())).thenReturn(gebruiker);

        boolean result = sut.checkWachtwoord(dto, "wachtwoord");
        assertTrue(result);
    }

    @Test
    public void ingevoerdWachtwoordKloptNiet() {
        Gebruiker gebruiker = Gebruiker.builder().email("gebuiker").wachtwoord("wachtwoord").build();

        GebruikerDto dto = new GebruikerDto();
        dto.setEmail("gebruiker");

        when(dao.select(dto.getEmail())).thenReturn(gebruiker);

        boolean result = sut.checkWachtwoord(dto, "verkeerdwachtwoord");

        assertFalse(result);
    }

    @Test
    public void testGebruikerNaarDtoConverter() {
        List<Levering> leveringen = Arrays.asList(Levering.AFHALEN, Levering.VERSTUREN);
        Gebruiker gebruiker = new Gebruiker("email", "wachtwoord", leveringen);
        GebruikerDto expected = new GebruikerDto("email", leveringen);

        GebruikerDto actual = this.sut.vanGebruikerNaarDto(gebruiker);

        assertEquals(expected, actual);
    }

}