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
import org.springframework.web.bind.annotation.RestController;

import com.example.kuaforrandevusistemi.dto.yoneticiDTO;
import com.example.kuaforrandevusistemi.service.yoneticiService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/yoneticiler")
public class yoneticiController {
    private yoneticiService yoneticiService;

    @PostMapping
    public ResponseEntity<yoneticiDTO> yoneticiYarat(@RequestBody yoneticiDTO yoneticiDTO) {
        yoneticiDTO kayitEdilmisYonetici = yoneticiService.yoneticiYarat(yoneticiDTO);
        return new ResponseEntity<>(kayitEdilmisYonetici, HttpStatus.CREATED);
    }

    @GetMapping("{idYonetici}")
    public ResponseEntity<yoneticiDTO> idIleGetirYonetici(@PathVariable("id") Long yoneticiId) {
        yoneticiDTO yoneticiDTO = yoneticiService.idIleGetirYonetici(yoneticiId);
        return ResponseEntity.ok(yoneticiDTO);
    }

    @GetMapping
    public ResponseEntity<List<yoneticiDTO>> tumYoneticileriGetir() {
        List<yoneticiDTO> yoneticiDTOList = yoneticiService.tumYoneticileriGetir();
        return ResponseEntity.ok(yoneticiDTOList);
    }

    @PutMapping("{idYonetici}")
    public ResponseEntity<yoneticiDTO> yoneticiGuncelle(@PathVariable("id") Long yoneticiId,
            @RequestBody yoneticiDTO guncelYoneticiDTO) {
        yoneticiDTO yoneticiDTO = yoneticiService.yoneticiGuncelle(yoneticiId, guncelYoneticiDTO);
        return ResponseEntity.ok(yoneticiDTO);
    }

    @DeleteMapping("{idYonetici}")
    public ResponseEntity<String> yoneticiSil(@PathVariable("id") Long yoneticiId) {
        yoneticiService.yoneticiSil(yoneticiId);
        return ResponseEntity.ok("Yönetici başarıyla silindi.");
    }
}
