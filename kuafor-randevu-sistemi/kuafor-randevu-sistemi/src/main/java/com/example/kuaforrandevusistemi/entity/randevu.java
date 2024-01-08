package com.example.kuaforrandevusistemi.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "randevular")
public class randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRandevu;
    private String kuafor;
    private String islem;
    private String diger;
    private String not;
    private LocalDate tarih;
    private LocalTime saat;
}
