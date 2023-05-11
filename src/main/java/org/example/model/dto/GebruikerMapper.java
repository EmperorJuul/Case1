package org.example.model.dto;

import org.example.model.Gebruiker;
import org.mapstruct.Mapper;

@Mapper
public interface GebruikerMapper {
    GebruikerDto naarDto(Gebruiker gebruiker);

    Gebruiker naarGebruiker(GebruikerDto dto);

}
