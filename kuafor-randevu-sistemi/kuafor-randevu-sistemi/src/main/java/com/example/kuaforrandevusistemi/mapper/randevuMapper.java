package com.example.kuaforrandevusistemi.mapper;

import com.example.kuaforrandevusistemi.dto.randevuDTO;
import com.example.kuaforrandevusistemi.entity.randevu;

public class randevuMapper {
    public static randevuDTO mapToRandevuDTO(randevu randevu) {
        return new randevuDTO(
                randevu.getIdRandevu(),
                randevu.getKuafor(),
                randevu.getIslem(),
                randevu.getDiger(),
                randevu.getNot(),
                randevu.getTarih(),
                randevu.getSaat());
    }

    public static randevu mapToRandevu(randevuDTO randevuDTO) {
        return new randevu(
                randevuDTO.getIdRandevu(),
                randevuDTO.getKuafor(),
                randevuDTO.getIslem(),
                randevuDTO.getDiger(),
                randevuDTO.getNot(),
                randevuDTO.getTarih(),
                randevuDTO.getSaat());
    }
}
