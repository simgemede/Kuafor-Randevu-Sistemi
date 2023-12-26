package com.example.kuaforrandevusistemi.mapper;

import com.example.kuaforrandevusistemi.dto.kullaniciDTO;
import com.example.kuaforrandevusistemi.entity.kullanici;

public class kullaniciMapper {

    public static kullaniciDTO mapToKullanici(kullanici kullanici) {
        return new kullaniciDTO(
                kullanici.getId(),
                kullanici.getAd(),
                kullanici.getSoyad(),
                kullanici.getEmail(),
                kullanici.getTelno(),
                kullanici.getSifre());
    }

    public static kullanici mapToKullanici(kullaniciDTO kullaniciDTO) {
        return new kullanici(
                kullaniciDTO.getId(),
                kullaniciDTO.getAd(),
                kullaniciDTO.getSoyad(),
                kullaniciDTO.getEmail(),
                kullaniciDTO.getTelno(),
                kullaniciDTO.getSifre());
    }
}