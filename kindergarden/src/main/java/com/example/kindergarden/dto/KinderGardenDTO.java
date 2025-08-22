package com.example.kindergarden.dto;

import jakarta.persistence.Column;

public class KinderGardenDTO {
    private Long id;
    private String firmName;

    public KinderGardenDTO(Long id, String firmName) {
        this.id = id;
        this.firmName = firmName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }
}
