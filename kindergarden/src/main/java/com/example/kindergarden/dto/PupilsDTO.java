package com.example.kindergarden.dto;

import com.example.kindergarden.Entity.KinderGardens;
import com.example.kindergarden.Entity.Parents;
import jakarta.persistence.Column;

public class PupilsDTO {

    private Long Id;
    private String name;
    private String sname;
    private String lname;
    private Boolean isActive;
    private Parents parents;
    private KinderGardens kinderGardens;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }

    public KinderGardens getKinderGardens() {
        return kinderGardens;
    }

    public void setKinderGardens(KinderGardens kinderGardens) {
        this.kinderGardens = kinderGardens;
    }
}

