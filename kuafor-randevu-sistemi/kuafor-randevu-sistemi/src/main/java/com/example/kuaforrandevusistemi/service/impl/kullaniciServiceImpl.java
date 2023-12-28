package com.example.kuaforrandevusistemi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kuaforrandevusistemi.dto.kullaniciDTO;
import com.example.kuaforrandevusistemi.entity.kullanici;
import com.example.kuaforrandevusistemi.exception.kaynakBulunamadiException;
import com.example.kuaforrandevusistemi.mapper.kullaniciMapper;
import com.example.kuaforrandevusistemi.repository.kullaniciRepository;
import com.example.kuaforrandevusistemi.service.kullaniciService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class kullaniciServiceImpl implements kullaniciService {
    private kullaniciRepository kullaniciRepository;

    @Override
    public kullaniciDTO kullaniciYarat(kullaniciDTO kullaniciDTO) {
        kullanici kullanici = kullaniciMapper.mapToKullanici(kullaniciDTO);
        kullanici kaydedilmisKullanici = kullaniciRepository.save(kullanici);
        return kullaniciMapper.mapToKullanici(kaydedilmisKullanici);
    }

    @Override
    public kullaniciDTO IdIleGetir(Long kullaniciId) {
        kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir personel bulunamadi. Id: " + kullaniciId));
        return kullaniciMapper.mapToKullanici(kullanici);
    }

    @Override
    public List<kullaniciDTO> tumKullanicilarGetir() {
        List<kullanici> kullanicilar = kullaniciRepository.findAll();
        return kullanicilar.stream().map((kullanici) -> kullaniciMapper.mapToKullanici(kullanici))
                .collect(Collectors.toList());
    }

    @Override
    public kullaniciDTO kullaniciGuncelle(Long kullaniciId, kullaniciDTO guncellenenKullanici) {
        kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir kullanıcı bulunamadı. Id: " + kullaniciId));

        kullanici.setAd(guncellenenKullanici.getAd());
        kullanici.setSoyad(guncellenenKullanici.getSoyad());
        kullanici.setEmail(guncellenenKullanici.getEmail());
        kullanici.setTelno(guncellenenKullanici.getTelno());
        kullanici.setSifre(guncellenenKullanici.getSifre());

        kullanici veritabanindaGuncellenmisKullanici = kullaniciRepository.save(kullanici);
        return kullaniciMapper.mapToKullanici(veritabanindaGuncellenmisKullanici);
    }

    @Override
    public void kullaniciSil(Long kullaniciId) {
        kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir kullanıcı bulunamadı. Id: " + kullaniciId));

        kullaniciRepository.deleteById(kullaniciId);
    }

}
