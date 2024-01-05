package com.example.kuaforrandevusistemi.service;

import java.util.List;

import com.example.kuaforrandevusistemi.dto.kullaniciDTO;

public interface kullaniciService {

    kullaniciDTO kullaniciYarat(kullaniciDTO kullaniciDTO);

    kullaniciDTO IdIleGetir(Long kullaniciId);

    List<kullaniciDTO> tumKullanicilarGetir();

    kullaniciDTO kullaniciGuncelle(Long kullaniciId, kullaniciDTO guncellenenKullanici);

    void kullaniciSil(Long kullaniciId);

}
