package com.example.kuaforrandevusistemi.service;

import java.util.List;

import com.example.kuaforrandevusistemi.dto.randevuDTO;

public interface randevuService {
    randevuDTO randevuYarat(randevuDTO randevuDTO);

    randevuDTO idIleGetirRandevu(Long randevuId);

    List<randevuDTO> tumRandevulariGetir();

    randevuDTO randevuGuncelle(Long randevuId, randevuDTO guncellenenRandevu);

    void randevuSil(Long randevuId);
}
