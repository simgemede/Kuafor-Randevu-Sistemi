package com.example.kuaforrandevusistemi.service;

import java.util.List;

import com.example.kuaforrandevusistemi.dto.kuaforDTO;

public interface kuaforService {
    kuaforDTO kuaforYarat(kuaforDTO kuaforDTO);

    kuaforDTO idIleGetirKuafor(Long kuaforId);

    List<kuaforDTO> tumKuaforleriGetir();

    kuaforDTO kuaforGuncelle(Long kuaforId, kuaforDTO guncellenenKuafor);

    void kuaforSil(Long kuaforId);
}
