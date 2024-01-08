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

import com.example.kuaforrandevusistemi.dto.randevuDTO;
import com.example.kuaforrandevusistemi.service.randevuService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/randevular")
public class randevuController {
    private randevuService randevuService;

    @PostMapping
    public ResponseEntity<randevuDTO> randevuYarat(@RequestBody randevuDTO randevuDTO) {
        randevuDTO kayitEdilmisRandevu = randevuService.randevuYarat(randevuDTO);
        return new ResponseEntity<>(kayitEdilmisRandevu, HttpStatus.CREATED);
    }

    @GetMapping("{idRandevu}")
    public ResponseEntity<randevuDTO> idIleGetirRandevu(@PathVariable("idRandevu") Long randevuId) {
        randevuDTO randevuDTO = randevuService.idIleGetirRandevu(randevuId);
        return ResponseEntity.ok(randevuDTO);
    }

    @GetMapping
    public ResponseEntity<List<randevuDTO>> tumRandevulariGetir() {
        List<randevuDTO> randevuDTOList = randevuService.tumRandevulariGetir();
        return ResponseEntity.ok(randevuDTOList);
    }

    @PutMapping("{idRandevu}")
    public ResponseEntity<randevuDTO> randevuGuncelle(@PathVariable("idRandevu") Long randevuId,
            @RequestBody randevuDTO guncelRandevuDTO) {
        randevuDTO randevuDTO = randevuService.randevuGuncelle(randevuId, guncelRandevuDTO);
        return ResponseEntity.ok(randevuDTO);
    }

    @DeleteMapping("{idRandevu}")
    public ResponseEntity<String> randevuSil(@PathVariable("idRandevu") Long randevuId) {
        randevuService.randevuSil(randevuId);
        return ResponseEntity.ok("Randevu başarıyla silindi.");
    }
}
