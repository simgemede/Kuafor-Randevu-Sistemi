package com.example.kuaforrandevusistemi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@Table(name = "yöneticiler")
public class yonetici {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idYonetici;
    private String adYonetici;
    private String soyadYonetici;
    @Column(name = "email_id_yonetici", nullable = false, unique = true)
    private String emailYonetici;
    private String telnoYonetici;
    private String sifreYonetici;
}
