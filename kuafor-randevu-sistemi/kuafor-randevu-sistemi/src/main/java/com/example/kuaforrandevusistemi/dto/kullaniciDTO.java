package com.example.kuaforrandevusistemi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class kullaniciDTO {
    private long id;
    private String ad;
    private String soyad;
    private String email;
    private String telno;
    private String sifre;
}