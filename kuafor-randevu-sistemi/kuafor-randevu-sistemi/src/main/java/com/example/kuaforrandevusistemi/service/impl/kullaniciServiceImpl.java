package com.example.kuaforrandevusistemi.service.impl;

import org.springframework.stereotype.Service;

import com.example.kuaforrandevusistemi.dto.kullaniciDTO;
import com.example.kuaforrandevusistemi.entity.kullanici;
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
        kullanici kaydedilmiskullKullanici = kullaniciRepository.save(kullanici);
        return kullaniciMapper.mapToKullanici(kaydedilmiskullKullanici);
    }
}
