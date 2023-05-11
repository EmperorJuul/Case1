package org.example.model.dto;

import org.example.model.Levering;

import java.util.List;

public record GebruikerDto(
        String email,
        List<Levering> levering
) {

}
