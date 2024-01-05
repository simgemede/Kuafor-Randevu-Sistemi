package com.example.kuaforrandevusistemi.service;

import java.util.List;

import com.example.kuaforrandevusistemi.dto.kullaniciDTO;

public interface kullaniciService {

    kullaniciDTO kullaniciYarat(kullaniciDTO kullaniciDTO);

    kullaniciDTO IdIleGetir(Long kullaniciId);

    List<kullaniciDTO> tumKullanicilarGetir();

    kullaniciDTO kullaniciGuncelle(Long kullaniciId, kullaniciDTO guncellenenKullanici);

    void kullaniciSil(Long kullaniciId);

 @Autowired
    public MusteriService(MusteriRepository musteriRepository) {
        this.musteriRepository = musteriRepository;
    }

    public void kaydet(String ad, String soyad) {
        Musteri musteri = new Musteri();
        musteri.setAd(ad);
        musteri.setSoyad(soyad);
        musteriRepository.save(musteri);
    }

}
