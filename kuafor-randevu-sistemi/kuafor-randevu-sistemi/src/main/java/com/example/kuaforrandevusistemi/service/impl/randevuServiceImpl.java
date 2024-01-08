package com.example.kuaforrandevusistemi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kuaforrandevusistemi.dto.randevuDTO;
import com.example.kuaforrandevusistemi.entity.randevu;
import com.example.kuaforrandevusistemi.exception.kaynakBulunamadiException;
import com.example.kuaforrandevusistemi.mapper.randevuMapper;
import com.example.kuaforrandevusistemi.repository.randevuRepository;
import com.example.kuaforrandevusistemi.service.randevuService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class randevuServiceImpl implements randevuService {
    private randevuRepository randevuRepository;

    @Override
    public randevuDTO randevuYarat(randevuDTO randevuDTO) {
        randevu randevu = randevuMapper.mapToRandevu(randevuDTO);
        randevu kaydedilmisRandevu = randevuRepository.save(randevu);
        return randevuMapper.mapToRandevuDTO(kaydedilmisRandevu);
    }

    @Override
    public randevuDTO idIleGetirRandevu(Long randevuId) {
        randevu randevu = randevuRepository.findById(randevuId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir randevu bulunamadı. Id: " + randevuId));
        return randevuMapper.mapToRandevuDTO(randevu);
    }

    @Override
    public List<randevuDTO> tumRandevulariGetir() {
        List<randevu> randevular = randevuRepository.findAll();
        return randevular.stream().map((randevu) -> randevuMapper.mapToRandevuDTO(randevu))
                .collect(Collectors.toList());
    }

    @Override
    public randevuDTO randevuGuncelle(Long randevuId, randevuDTO guncellenenRandevu) {
        randevu randevu = randevuRepository.findById(randevuId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir randevu bulunamadı. Id: " + randevuId));

        randevu.setKuafor(guncellenenRandevu.getKuafor());
        randevu.setIslem(guncellenenRandevu.getIslem());
        randevu.setDiger(guncellenenRandevu.getDiger());
        randevu.setNot(guncellenenRandevu.getNot());
        randevu.setTarih(guncellenenRandevu.getTarih());
        randevu.setSaat(guncellenenRandevu.getSaat());

        randevu veritabanindaGuncellenmisRandevu = randevuRepository.save(randevu);
        return randevuMapper.mapToRandevuDTO(veritabanindaGuncellenmisRandevu);
    }

    @Override
    public void randevuSil(Long randevuId) {
        randevu randevu = randevuRepository.findById(randevuId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir randevu bulunamadı. Id: " + randevuId));

        randevuRepository.deleteById(randevuId);
    }
}
