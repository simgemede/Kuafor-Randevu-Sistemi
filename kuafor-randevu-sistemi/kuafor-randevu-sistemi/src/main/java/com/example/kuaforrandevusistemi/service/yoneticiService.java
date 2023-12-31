package com.example.kuaforrandevusistemi.service;

import java.util.List;

import com.example.kuaforrandevusistemi.dto.yoneticiDTO;

public interface yoneticiService {
    yoneticiDTO yoneticiYarat(yoneticiDTO yoneticiDTO);

    yoneticiDTO idIleGetirYonetici(Long yoneticiId);

    List<yoneticiDTO> tumYoneticileriGetir();

    yoneticiDTO yoneticiGuncelle(Long yoneticiId, yoneticiDTO guncellenenYonetici);

    void yoneticiSil(Long yoneticiId);
}
