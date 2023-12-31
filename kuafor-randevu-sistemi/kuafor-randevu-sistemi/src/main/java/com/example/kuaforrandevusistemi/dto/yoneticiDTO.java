package com.example.kuaforrandevusistemi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class yoneticiDTO {
    private Long idYonetici;
    private String adYonetici;
    private String soyadYonetici;
    private String emailYonetici;
    private String telnoYonetici;
    private String sifreYonetici;
}
