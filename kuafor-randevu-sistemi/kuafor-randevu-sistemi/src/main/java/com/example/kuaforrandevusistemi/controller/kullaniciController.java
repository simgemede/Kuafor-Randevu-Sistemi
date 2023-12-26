package com.example.kuaforrandevusistemi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kuaforrandevusistemi.dto.kullaniciDTO;
import com.example.kuaforrandevusistemi.service.kullaniciService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/kullanicilar")
public class kullaniciController {
    private kullaniciService kullaniciService;

    @PostMapping
    public ResponseEntity<kullaniciDTO> kullaniciYarat(@RequestBody kullaniciDTO kullaniciDTO) {
        kullaniciDTO kayitEdilmisKullanici = kullaniciService.kullaniciYarat(kullaniciDTO);
        return new ResponseEntity<>(kayitEdilmisKullanici, HttpStatus.CREATED);
    }
}