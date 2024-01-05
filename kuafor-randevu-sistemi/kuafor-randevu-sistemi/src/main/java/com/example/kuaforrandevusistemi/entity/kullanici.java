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
@Table(name = "musteriKayit")

public class musteriKayit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< Updated upstream
    private Long id;
    private String ad;
    private String soyad;
    @Column(name = "email_id", nullable = false, unique = true)
    private String email;
    private String telno;
=======
    private String adSoyad;
    @Column(name = "eposta_id", nullable = false, unique = true)
    private String mail;
    private String telNo;
>>>>>>> Stashed changes
    private String sifre;

}