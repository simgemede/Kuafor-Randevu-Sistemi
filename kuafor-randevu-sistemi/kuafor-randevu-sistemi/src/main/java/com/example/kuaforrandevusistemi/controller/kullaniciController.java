package com.example.kuaforrandevusistemi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("{id}")
    public ResponseEntity<kullaniciDTO> IdIleGetir(@PathVariable("id") Long kullaniciId) {
        kullaniciDTO kullaniciDTO = kullaniciService.IdIleGetir(kullaniciId);
        return ResponseEntity.ok(kullaniciDTO);
    }

    @GetMapping
    public ResponseEntity<List<kullaniciDTO>> tumKullanicilarGetir() {
        List<kullaniciDTO> kullaniciDTOList = kullaniciService.tumKullanicilarGetir();
        return ResponseEntity.ok(kullaniciDTOList);
    }

    @PutMapping("{id}")
    public ResponseEntity<kullaniciDTO> kullaniciGuncelle(@PathVariable("id") Long kullaniciId,
            @RequestBody kullaniciDTO guncelKullaniciDTO) {
        kullaniciDTO kullaniciDTO = kullaniciService.kullaniciGuncelle(kullaniciId, guncelKullaniciDTO);
        return ResponseEntity.ok(kullaniciDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> kullaniciSil(@PathVariable("id") Long kullaniciId) {
        kullaniciService.kullaniciSil(kullaniciId);
        return ResponseEntity.ok("Kullanıcı başarıyla silindi.");
    }

    @PostMapping("kaydet")
    public String musteriKayit(@RequestParam String ad, @RequestParam String soyad) {
        kullaniciService.kaydet(ad, soyad);
        return "Kayıt başarıyla eklendi.";
    }

}