package com.example.kuaforrandevusistemi.mapper;

import com.example.kuaforrandevusistemi.dto.kuaforDTO;
import com.example.kuaforrandevusistemi.entity.kuafor;

public class kuaforMapper {
    public static kuaforDTO mapToKuaforDTO(kuafor kuafor) {
        return new kuaforDTO(
                kuafor.getIdKuafor(),
                kuafor.getAdKuafor(),
                kuafor.getSoyadKuafor(),
                kuafor.getEmailKuafor(),
                kuafor.getTelnoKuafor(),
                kuafor.getSifreKuafor());
    }

    public static kuafor mapToKuafor(kuaforDTO kuaforDTO) {
        return new kuafor(
                kuaforDTO.getIdKuafor(),
                kuaforDTO.getAdKuafor(),
                kuaforDTO.getSoyadKuafor(),
                kuaforDTO.getEmailKuafor(),
                kuaforDTO.getTelnoKuafor(),
                kuaforDTO.getSifreKuafor());
    }
}
