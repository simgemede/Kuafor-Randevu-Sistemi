package com.example.kuaforrandevusistemi.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class randevuDTO {
    private Long idRandevu;
    private String kuafor;
    private String islem;
    private String diger;
    private String not;
    private LocalDate tarih;
    private LocalTime saat;
}
