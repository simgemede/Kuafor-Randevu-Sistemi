package com.example.kuaforrandevusistemi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kuaforler")
public class kuafor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKuafor;
    private String adKuafor;
    private String soyadKuafor;
    @Column(name = "eposta_id_kuafor", nullable = false, unique = true)
    private String epostaKuafor;
    private String telnoKuafor;
    private String sifreKuafor;
}