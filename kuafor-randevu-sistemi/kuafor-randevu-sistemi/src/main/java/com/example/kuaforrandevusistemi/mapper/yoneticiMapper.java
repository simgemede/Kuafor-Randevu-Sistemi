package com.example.kuaforrandevusistemi.mapper;

import com.example.kuaforrandevusistemi.dto.yoneticiDTO;
import com.example.kuaforrandevusistemi.entity.yonetici;

public class yoneticiMapper {
    public static yoneticiDTO mapToYoneticiDTO(yonetici yonetici) {
        return new yoneticiDTO(
                yonetici.getIdYonetici(),
                yonetici.getAdYonetici(),
                yonetici.getSoyadYonetici(),
                yonetici.getEmailYonetici(),
                yonetici.getTelnoYonetici(),
                yonetici.getSifreYonetici());
    }

    public static yonetici mapToYonetici(yoneticiDTO yoneticiDTO) {
        return new yonetici(
                yoneticiDTO.getIdYonetici(),
                yoneticiDTO.getAdYonetici(),
                yoneticiDTO.getSoyadYonetici(),
                yoneticiDTO.getEmailYonetici(),
                yoneticiDTO.getTelnoYonetici(),
                yoneticiDTO.getSifreYonetici());
    }
}
