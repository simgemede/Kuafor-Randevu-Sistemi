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

import com.example.kuaforrandevusistemi.dto.kuaforDTO;
import com.example.kuaforrandevusistemi.service.kuaforService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/kuaforler")
public class kuaforController {
    private kuaforService kuaforService;

    @PostMapping
    public ResponseEntity<kuaforDTO> kuaforYarat(@RequestBody kuaforDTO kuaforDTO) {
        kuaforDTO kayitEdilmisKuafor = kuaforService.kuaforYarat(kuaforDTO);
        return new ResponseEntity<>(kayitEdilmisKuafor, HttpStatus.CREATED);
    }

    @GetMapping("{idKuafor}")
    public ResponseEntity<kuaforDTO> idIleGetirKuafor(@PathVariable("id") Long kuaforId) {
        kuaforDTO kuaforDTO = kuaforService.idIleGetirKuafor(kuaforId);
        return ResponseEntity.ok(kuaforDTO);
    }

    @GetMapping
    public ResponseEntity<List<kuaforDTO>> tumKuaforleriGetir() {
        List<kuaforDTO> kuaforDTOList = kuaforService.tumKuaforleriGetir();
        return ResponseEntity.ok(kuaforDTOList);
    }

    @PutMapping("{idKuafor}")
    public ResponseEntity<kuaforDTO> kuaforGuncelle(@PathVariable("id") Long kuaforId,
            @RequestBody kuaforDTO guncelKuaforDTO) {
        kuaforDTO kuaforDTO = kuaforService.kuaforGuncelle(kuaforId, guncelKuaforDTO);
        return ResponseEntity.ok(kuaforDTO);
    }

    @DeleteMapping("{idKuafor}")
    public ResponseEntity<String> kuaforSil(@PathVariable("id") Long kuaforId) {
        kuaforService.kuaforSil(kuaforId);
        return ResponseEntity.ok("Kuaför başarıyla silindi.");
    }
}
