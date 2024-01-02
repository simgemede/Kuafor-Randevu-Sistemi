package com.example.kuaforrandevusistemi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kuaforrandevusistemi.dto.yoneticiDTO;
import com.example.kuaforrandevusistemi.entity.yonetici;
import com.example.kuaforrandevusistemi.exception.kaynakBulunamadiException;
import com.example.kuaforrandevusistemi.mapper.yoneticiMapper;
import com.example.kuaforrandevusistemi.repository.yoneticiRepository;
import com.example.kuaforrandevusistemi.service.yoneticiService;

import lombok.AllArgsConstructor;

//Admin Kuafor ekleme, güncelleme silme islem

@Service
@AllArgsConstructor
public class yoneticiServiceImpl implements yoneticiService {
    private yoneticiRepository yoneticiRepository;

    @Override
    public yoneticiDTO yoneticiYarat(yoneticiDTO yoneticiDTO) {
        yonetici yonetici = yoneticiMapper.mapToYonetici(yoneticiDTO);
        yonetici kaydedilmisYonetici = yoneticiRepository.save(yonetici);
        return yoneticiMapper.mapToYoneticiDTO(kaydedilmisYonetici);
    }

    @Override
    public yoneticiDTO idIleGetirYonetici(Long yoneticiId) {
        yonetici yonetici = yoneticiRepository.findById(yoneticiId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir yönetici bulunamadı. Id: " + yoneticiId));
        return yoneticiMapper.mapToYoneticiDTO(yonetici);
    }

    @Override
    public List<yoneticiDTO> tumYoneticileriGetir() {
        List<yonetici> yoneticiler = yoneticiRepository.findAll();
        return yoneticiler.stream().map((yonetici) -> yoneticiMapper.mapToYoneticiDTO(yonetici))
                .collect(Collectors.toList());
    }

    @Override
    public yoneticiDTO yoneticiGuncelle(Long yoneticiId, yoneticiDTO guncellenenYonetici) {
        yonetici yonetici = yoneticiRepository.findById(yoneticiId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir yönetici bulunamadı. Id: " + yoneticiId));

        yonetici.setAdYonetici(guncellenenYonetici.getAdYonetici());
        yonetici.setSoyadYonetici(guncellenenYonetici.getSoyadYonetici());
        yonetici.setEmailYonetici(guncellenenYonetici.getEmailYonetici());
        yonetici.setTelnoYonetici(guncellenenYonetici.getTelnoYonetici());
        yonetici.setSifreYonetici(guncellenenYonetici.getSifreYonetici());

        yonetici veritabanindaGuncellenmisYonetici = yoneticiRepository.save(yonetici);
        return yoneticiMapper.mapToYoneticiDTO(veritabanindaGuncellenmisYonetici);
    }

    @Override
    public void yoneticiSil(Long yoneticiId) {
        yonetici yonetici = yoneticiRepository.findById(yoneticiId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir yönetici bulunamadı. Id: " + yoneticiId));

        yoneticiRepository.deleteById(yoneticiId);
    }
}
