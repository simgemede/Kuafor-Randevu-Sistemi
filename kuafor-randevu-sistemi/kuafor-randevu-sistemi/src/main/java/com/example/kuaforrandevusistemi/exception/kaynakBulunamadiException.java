package com.example.kuaforrandevusistemi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class kaynakBulunamadiException extends RuntimeException {

    public kaynakBulunamadiException(String mesaj) {
        super(mesaj);
    }
}
