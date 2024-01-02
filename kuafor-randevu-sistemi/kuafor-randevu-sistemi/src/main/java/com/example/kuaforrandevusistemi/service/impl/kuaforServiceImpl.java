package com.example.kuaforrandevusistemi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kuaforrandevusistemi.dto.kuaforDTO;
import com.example.kuaforrandevusistemi.entity.kuafor;
import com.example.kuaforrandevusistemi.exception.kaynakBulunamadiException;
import com.example.kuaforrandevusistemi.mapper.kuaforMapper;
import com.example.kuaforrandevusistemi.repository.kuaforRepository;
import com.example.kuaforrandevusistemi.service.kuaforService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class kuaforServiceImpl implements kuaforService {
    private kuaforRepository kuaforRepository;

    @Override
    public kuaforDTO kuaforYarat(kuaforDTO kuaforDTO) {
        kuafor kuafor = kuaforMapper.mapToKuafor(kuaforDTO);
        kuafor kaydedilmisKuafor = kuaforRepository.save(kuafor);
        return kuaforMapper.mapToKuaforDTO(kaydedilmisKuafor);
    }

    @Override
    public kuaforDTO idIleGetirKuafor(Long kuaforId) {
        kuafor kuafor = kuaforRepository.findById(kuaforId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir kuaför bulunamadı. Id: " + kuaforId));
        return kuaforMapper.mapToKuaforDTO(kuafor);
    }

    @Override
    public List<kuaforDTO> tumKuaforleriGetir() {
        List<kuafor> kuaforler = kuaforRepository.findAll();
        return kuaforler.stream().map((kuafor) -> kuaforMapper.mapToKuaforDTO(kuafor))
                .collect(Collectors.toList());
    }

    @Override
    public kuaforDTO kuaforGuncelle(Long kuaforId, kuaforDTO guncellenenKuafor) {
        kuafor kuafor = kuaforRepository.findById(kuaforId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir kuaför bulunamadı. Id: " + kuaforId));

        kuafor.setAdKuafor(guncellenenKuafor.getAdKuafor());
        kuafor.setSoyadKuafor(guncellenenKuafor.getSoyadKuafor());
        kuafor.setEmailKuafor(guncellenenKuafor.getEmailKuafor());
        kuafor.setTelnoKuafor(guncellenenKuafor.getTelnoKuafor());
        kuafor.setSifreKuafor(guncellenenKuafor.getSifreKuafor());

        kuafor veritabanindaGuncellenmisKuafor = kuaforRepository.save(kuafor);
        return kuaforMapper.mapToKuaforDTO(veritabanindaGuncellenmisKuafor);
    }

    @Override
    public void kuaforSil(Long kuaforId) {
        kuafor kuafor = kuaforRepository.findById(kuaforId)
                .orElseThrow(() -> new kaynakBulunamadiException(
                        "Bu id ile kayıtlı bir kuaför bulunamadı. Id: " + kuaforId));

        kuaforRepository.deleteById(kuaforId);
    }
}
