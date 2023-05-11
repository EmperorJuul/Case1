package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.Levering;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GebruikerDto {


    String email;
    List<Levering> levering;

}
