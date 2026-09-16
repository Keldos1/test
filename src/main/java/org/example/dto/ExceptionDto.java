package org.example.dto;

import java.time.LocalDate;

public record ExceptionDto(
        String massage,
        String detailedMassage,
        LocalDate time
){
}
